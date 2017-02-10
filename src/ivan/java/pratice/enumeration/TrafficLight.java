package ivan.java.pratice.enumeration;

import static ivan.java.pratice.enumeration.Signal.*;

public class TrafficLight
{
	Signal color = RED;

	public void change()
	{
		switch (color)
		{
		case RED:
			color = Signal.GREEN;

			break;
		case GREEN:
			color = Signal.YELLOW;
			break;
		case YELLOW:
			color = Signal.RED;
		default:
			break;
		}
	}

	public String toString()
	{
		return "The traffic light is " + color;
	}

	public static void main(String[] args)
	{
		TrafficLight t = new TrafficLight();
		for (int i = 0; i < 7; i++)
		{
			System.out.println(t);
		}
	}
}
