package ivan.java.pratice.enumeration;

/**
 * Enumeration provider equals and hashcode method
 * 
 * @author lchen283
 *
 **/
public enum Shrubbery
{
	GROUND, CRAWLING, HANGING;

	public static void main(String[] args)
	{
		for (Shrubbery shrubbery : Shrubbery.values())
		{
			System.out.println(shrubbery + " ordinal: " + shrubbery.ordinal());
			System.out.println(shrubbery.compareTo(Shrubbery.CRAWLING) + " ");
			System.out.println(shrubbery.equals(Shrubbery.CRAWLING) + " ");
			System.out.println(shrubbery == Shrubbery.CRAWLING);
			System.out.println(shrubbery.name());
			System.out.println("--------------------------");
		}

		for (String s : "HANGING CRAWLING GROUND".split(" "))
		{
			Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
			System.out.println(shrub.ordinal());
		}
	}
}
