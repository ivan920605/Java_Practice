package ivan.java.practice.set;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 测试set set 集合不会有重复元素，hashSet 结果 已经对结果排序了
 * 
 * @author ivan
 *
 */
public class SetOfInteger
{
	public static void main(String[] args)
	{
		Random random = new Random(47);
		Set<Integer> intset = new HashSet<>();
		for (int i = 0; i < 1000; i++)
		{
			intset.add(random.nextInt(30));
		}
		System.out.println(intset);
	}
}
