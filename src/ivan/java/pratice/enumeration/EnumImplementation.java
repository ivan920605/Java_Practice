package ivan.java.pratice.enumeration;

import java.util.Random;

import ivan.java.pratice.util.Generator;

enum CartoonCharacter implements Generator<CartoonCharacter>
{
	SLAPPY, SPANK, PUNCHY, SILIY, BOUNCY, NOUTTY, BOB;

	private static Random rand = new Random(47);

	public CartoonCharacter next()
	{
		return values()[rand.nextInt(values().length)];
	}

	public static CartoonCharacter staticNext()
	{
		return values()[rand.nextInt(values().length)];
	}
}

public class EnumImplementation
{
	public static <T> void printNext(Generator<T> rg)
	{
		System.out.print(rg.next() + ", ");
	}

	public static void main(String[] args)
	{
		// choose any instance
		CartoonCharacter cc = CartoonCharacter.BOB;
		for (int i = 0; i < 10; i++)
		{
			printNext(cc);
		}
	}
}
