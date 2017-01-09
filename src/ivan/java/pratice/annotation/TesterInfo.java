package ivan.java.pratice.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // can use in class level only
public @interface TesterInfo
{
	public enum Priority
	{
		LOW, MEDIUM, HIGH
	}

	Priority priority() default Priority.MEDIUM;

	String[] tags() default "";


	String lastModified() default "09/01/2017";
}
