package ivan.java.pratice.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 
 * 注解处理器
 * @author lchen283
 *
 */
public class RunTest
{

	public static void main(String[] args) throws Exception
	{
		System.out.println("Testing...");

		int passed = 0, failed = 0, count = 0, ignore = 0;

		Class<TestExample> object = TestExample.class;

		if (object.isAnnotationPresent(TesterInfo.class))
		{
			Annotation annotation = object.getAnnotation(TesterInfo.class);
			TesterInfo testerInfo = (TesterInfo) annotation;

			System.out.printf("%nPriority :%s", testerInfo.priority());
			System.out.printf("%nCreatedBy :%s", testerInfo.createdBy());
			System.out.printf("%nTags :", testerInfo.tags().toString());

			for (Method method : object.getDeclaredMethods())
			{
				if (method.isAnnotationPresent(Test.class))
				{
					Annotation annotation2 = method.getAnnotation(Test.class);
					Test test = (Test) annotation2;

					// if enabled = true default
					try
					{
						if (test.enabled())
						{
							method.invoke(object.newInstance());
							System.out.printf("%s - Test '%s' - passed %n", ++count, method.getName());
							passed++;
						}
						else
						{
							System.out.printf("%s - Test '%s' - ignored%n", ++count, method.getName());
							ignore++;
						}
					}
					catch (Throwable ex)
					{
						System.out.printf("%s - Test '%s' - failed: %s %n", ++count, method.getName(), ex.getCause());
						failed++;
					}
				}
			}
		}

		System.out.printf("%nResult : Total : %d, Passed: %d, Failed %d, Ignore %d%n", count, passed, failed, ignore);
	}
}
