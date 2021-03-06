package ivan.java.pratice.enumeration;

import ivan.java.pratice.util.Enums;

enum SecurityCategory
{
	STOCK(Security.Stock.class), BOND(Security.Bond.class);

	Security[] values;

	private SecurityCategory(Class<? extends Security> Kind)
	{
		values = Kind.getEnumConstants();
	}

	public interface Security
	{
		enum Stock implements Security
		{
			SHORT, LONG, MARGIN
		}

		enum Bond implements Security
		{
			MUNICIPAL, JUNK
		}

	}

	public Security randomSelection()
	{
		return Enums.random(values);
	}

	public static void main(String[] args)
	{
		for (int i = 0; i < 10; i++)
		{
			SecurityCategory category = Enums.random(SecurityCategory.class);
			System.out.println(category + ": " + category.randomSelection());
		}
	}

}
