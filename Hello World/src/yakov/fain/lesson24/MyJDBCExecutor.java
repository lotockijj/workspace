package yakov.fain.lesson24;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Documented
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)

public @interface MyJDBCExecutor {
	//String value();

	String sqlStatement();
	boolean transactionRequired() default false;
	boolean notifyOnUpdates() default false; 
}
