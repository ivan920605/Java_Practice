package ivan.java.practice;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.ivan.datatransfer.RoleEnum;
import com.ivan.datatransfer.User;

public class JacksonMapper
{
	public static void main(String[] args) throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();

		File jsonFile = new File("C://Users//lchen283//Desktop//user_data.json");
		// User user = mapper.readValue(jsonFile, User.class);

		TypeReference<List<User>> mapperType = new TypeReference<List<User>>()
		{
		};
		List<User> userList = mapper.readValue(jsonFile, mapperType);

		PrintWriter writer = new PrintWriter("user.sql", "UTF-8");
		for (User u : userList) {
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO DIM_USERS ( domain,marketteam,departmentid,email,roleid,password,isactive, isfirstlogin,createdate,updatedate) VALUES (");
			sb.append("'IS-IMAT',");
			sb.append("'Advance Analytic Technology',");
			sb.append("'D21',");
			sb.append("'"+u.getEmail()+"',");
			sb.append("'"+RoleEnum.getValue(u.getRole())+"',");
			sb.append("'"+u.getPassword()+"',");
			sb.append("true,");
			sb.append("false,");
			sb.append("now(),");
			sb.append("now());");
			writer.println(sb.toString());
		}
		writer.close();
	}
}
