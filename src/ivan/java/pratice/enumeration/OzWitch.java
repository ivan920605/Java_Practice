package ivan.java.pratice.enumeration;

public enum OzWitch
{
	// Instances must be defined first, before methods
	WEST("Miss Gulch, aka thid Wicked Witch of the west"), NORTH("Glinda, the God Witch of the North"), EAST(
			"Wicked witch of the East, wearer of the Ruby " + "Slippers, crushed by Dorothy's house"), SOUTH(
					"Good by inference, but missing");

	private String description;

	private OzWitch(String description)
	{
		this.description = description;
	}

	public String getDescription()
	{
		return description;
	}

	public static void main(String[] args)
	{
		for (OzWitch witch : OzWitch.values())
		{
			System.out.println(witch + ": " + witch.getDescription());
			System.out.println(witch.name());
		}
	}
}
