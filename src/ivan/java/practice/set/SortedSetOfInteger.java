package ivan.java.practice.set;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SortedSetOfInteger
{
	public static void main(String[] args)
	{
		Random random = new Random(47);
		Set<Integer> intset = new TreeSet<>();
		for (int i = 0; i < 10000; i++)
		{
			intset.add(random.nextInt(30));
		}
		System.out.println(intset);
	}
}
