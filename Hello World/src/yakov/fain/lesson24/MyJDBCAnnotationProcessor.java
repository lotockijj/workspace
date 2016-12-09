package yakov.fain.lesson24;

import java.lang.reflect.Method;

public class MyJDBCAnnotationProcessor {
	
	public static void main(String[] args) {
		//TODO add a check for the number of command line arguments
		// has to be the name of the class to load.
		String classWithAnnotation = args[0];
		try{
			// Load provided on the command line class
			Class loadedClass = Class.forName(classWithAnnotation);
			//Get references to class methods
			Method[] methods = loadedClass.getMethods();
			//Check every method of the class. If the annotation is present, 
			//print the values of its parameters
			for(Method m : methods){
				if(m.isAnnotationPresent(MyJDBCExecutor.class)){
					MyJDBCExecutor jdbcAnnotation = 
							m.getAnnotation(MyJDBCExecutor.class);
					System.out.println("Method: " + m.getName() + 
							". Parameters of MyJDBCExecutor are: " + 
							"sqlStatement=" + jdbcAnnotation.sqlStatement() +
							", transactionRequired=" + jdbcAnnotation.transactionRequired());
				}
			}
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}

}