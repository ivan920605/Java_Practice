package ivan.java.pratice.enumeration;

import ivan.java.pratice.util.Enums;

public enum Course
{
	APPETIZER(Food.Appetizer.class), MAINCOURSE(Food.MainCourse.class), DESSERT(Food.Dessert.class), COFFEE(
			Food.Coffee.class);

	private Food[] values;

	private Course(Class<? extends Food> Kind)
	{
		values = Kind.getEnumConstants();
	}

	public Food randomSelection()
	{
		return Enums.random(values);
	}
}
