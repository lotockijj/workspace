package yakov.fain.lesson24;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import yakov.fain.lesson24.MyJDBCExecutor;

public class MyJDBCAnnotationProcessor {
	
	public static void main(String[] args) {
		String classWithAnnotation = "yakov.fain.lesson24.HRBrowser";
		try{
			Class<?> loadedClass = Class.forName(classWithAnnotation);
			Method[] methods = loadedClass.getMethods();
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
			
			Class parameterTypes[] = new Class[]{String.class};
			Method myMethod = loadedClass.getMethod("changeAddress", parameterTypes);
			Object arguments[] = new Object[1];
			arguments[0] = "250 Broadway";
			myMethod.invoke(loadedClass.newInstance(), arguments);
			arguments[0] = "c. Belz";
			myMethod.invoke(loadedClass.newInstance(), arguments);
			myMethod.invoke(loadedClass.newInstance(), "SOS");
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch(NoSuchMethodException e1){
			e1.printStackTrace();
		} catch(SecurityException e2){
			e2.printStackTrace();
		} catch(IllegalAccessException e3){
			e3.printStackTrace();
		} catch (IllegalArgumentException e4){
			e4.printStackTrace();
		} catch (InvocationTargetException e5){
			e5.printStackTrace();
		} catch (InstantiationException e6){
			e6.printStackTrace();
		}
	}

}
