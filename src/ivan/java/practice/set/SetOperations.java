package ivan.java.practice.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 
 * @author
 *
 */
public class SetOperations
{
	public static void main(String[] args)
	{
		Set<String> set = new HashSet<String>();
		Collections.addAll(set, "A B C D E F G H I J K L".split(" "));

		boolean flag = set.add("M");
		System.out.println("H: " + set.contains("H"));
		System.out.println("N: " + set.contains("N"));

		Set<String> set1 = new HashSet<>();
		Collections.addAll(set1, "A B".split(" "));
		System.out.println("set1: " + set1);
		System.out.println("set1 in set " + set.contains(set1));
		set.remove("H");
		System.out.println("Set: " + set);
		System.out.println("set1 in set " + set.contains(set1));
		set.removeAll(set1);
		System.out.println("set1 removed from set　" + set);
		Collections.addAll(set, "X Y Z".split(" "));
		System.out.println("'X Y Z' added to set: " + set);

	}
}
