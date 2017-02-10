package ivan.java.pratice.enumeration;

import static ivan.java.pratice.enumeration.AlarmPoints.BATHROOM;
import static ivan.java.pratice.enumeration.AlarmPoints.KITCHEN;
import static ivan.java.pratice.enumeration.AlarmPoints.OFFICE1;
import static ivan.java.pratice.enumeration.AlarmPoints.OFFICE4;
import static ivan.java.pratice.enumeration.AlarmPoints.STAIR1;
import static ivan.java.pratice.enumeration.AlarmPoints.STAIR2;

import java.util.EnumSet;

public class EnumSets
{
	public static void main(String[] args)
	{
		EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
		points.add(BATHROOM);
		System.out.println(points);

		points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
		System.out.println(points);

		points = points.allOf(AlarmPoints.class);
		points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
		System.out.println(points);

		points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
		System.out.println(points);

		points = EnumSet.complementOf(points);
		System.out.println(points);
	}
}
