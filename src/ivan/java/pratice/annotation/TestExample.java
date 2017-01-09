package ivan.java.pratice.annotation;

import ivan.java.pratice.annotation.TesterInfo.Priority;

public class TestExample
{
	@Test
	void testA()
	{
		if (true)
			throw new RuntimeException("The test always failed");
	}

	@Test(enabled = false)
	void testB()
	{
		if (false)
			throw new RuntimeException("The test always passed");

	}

	@Test(enabled = true)
	void testC()
	{
		if (10 > 1)
		{
			// do nothing, this test always passed.
		}
	}

}
