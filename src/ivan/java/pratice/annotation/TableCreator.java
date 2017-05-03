package ivan.java.pratice.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//annotations/database/Tablecreator.java
//Reflection-based annotation processor
//{Args:annotations.database.Member}
public class TableCreator
{
	public static void main(String[] args) throws Exception
	{
		/*
		 * if (args.length < 1) {
		 * System.out.println("arguments: annotated classess"); System.exit(0);
		 * }
		 */
		args = new String[] { "ivan.java.pratice.annotation.Member" };
		String finalTableCreator = "";
		for (String className : args) {
			System.out.println(className);
			Class<?> cl = Class.forName(className);
			DBTable dbTable = cl.getAnnotation(DBTable.class);
			if (dbTable == null) {
				System.out.println("No DBTable annotations in class " + className);
				continue;
			}

			String tableName = dbTable.name();
			if (tableName.length() < 1) {
				tableName = cl.getName().toUpperCase();
			}

			List<String> columnDefs = new ArrayList<String>();
			for (Field field : cl.getDeclaredFields()) {
				String columnName = null;
				Annotation[] anns = field.getDeclaredAnnotations();
				if (anns.length < 1)
					continue;
				if (anns[0] instanceof SQLInteger) {
					SQLInteger sInt = (SQLInteger) anns[0];
					if (sInt.name().length() < 1)
						columnName = field.getName().toUpperCase();
					else
						columnName = sInt.name();
					columnDefs.add(columnName + " int " + getConstraints(sInt.constraints()));
				}

				if (anns[0] instanceof SQLString) {
					SQLString sString = (SQLString) anns[0];
					if (sString.name().length() < 1)
						columnName = field.getName().toUpperCase();
					else
						columnName = sString.name();

					columnDefs.add(
							columnName + " VARCHAR(" + sString.value() + ")" + getConstraints(sString.constraints()));
				}

				if (anns[0] instanceof SQLBoolean) {
					SQLBoolean sboolean = (SQLBoolean) anns[0];
					if (sboolean.name().length() < 1) {
						columnName = field.getName().toUpperCase();
					} else {
						columnName = sboolean.name();
					}

					columnDefs.add(columnName + " bit(1) " + getConstraints(sboolean.constraints()));
				}

				StringBuilder creatorCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
				for (String columnDef : columnDefs)
					creatorCommand.append("\n    " + columnDef + ", ");
				String tableCreate = creatorCommand.substring(0, creatorCommand.lastIndexOf(",")) + ");";
				System.out.println("Table Creation SQL for " + className + "is  :\n" + tableCreate);
				finalTableCreator = tableCreate;

			}

		}

		System.out.println(finalTableCreator);
		Connection conn = getConnection();
		conn.createStatement().executeUpdate(finalTableCreator);

	}

	private static String getConstraints(Constraints con)
	{
		String constraints = "";
		if (!con.allowNull()) {
			constraints += " NOT NULL ";
		}
		if (con.primaryKey()) {
			constraints += " PRIMARY KEY ";
		}
		if (con.unique()) {
			constraints += " UNIQUE ";

		}

		return constraints;
	}

	private static Connection getConnection() throws Exception
	{
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", "postgres");
		connectionProps.put("password", "admin");

		conn = DriverManager.getConnection("jdbc:postgresql://localhost/test", connectionProps);

		System.out.println("Connected to database");
		return conn;
	}
}
