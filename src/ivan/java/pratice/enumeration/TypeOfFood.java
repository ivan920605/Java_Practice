package ivan.java.pratice.enumeration;

import ivan.java.pratice.enumeration.Food.Appetizer;
import ivan.java.pratice.enumeration.Food.Coffee;
import ivan.java.pratice.enumeration.Food.Dessert;
import ivan.java.pratice.enumeration.Food.MainCourse;

public class TypeOfFood
{
	public static void main(String[] args)
	{
		Food food = Appetizer.SALAD;
		food = MainCourse.LASAGNE;
		food = Dessert.GELATO;
		food = Coffee.CAPPUCCINO;
	}
}
