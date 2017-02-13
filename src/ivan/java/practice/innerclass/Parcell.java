package ivan.java.practice.innerclass;

public class Parcell
{
	class Contents
	{
		private int i = 11;

		public int value()
		{
			return i;
		}
	}

	class Destination
	{
		private String label;

		public Destination(String whereTo)
		{
			this.label = whereTo;
		}

		String readLabel()
		{
			return label;
		}
	}

	public void ship(String dest)
	{
		Contents contents = new Contents();
		Destination destination = new Destination(dest);
		System.out.println(destination.readLabel());
	}

	public static void main(String[] args)
	{
		Parcell p = new Parcell();
		p.ship("Tasmania");
	}
}
