package yakov.fain.lesson24;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionSample {
	
	public static void main(String[] args) {
		try{
			Class<?> c = Class.forName("yakov.fain.lesson24.Employee1");
			Method method[] = c.getDeclaredMethods();
			System.out.println("The Employee methods: ");
			
			for (int i = 0; i < method.length; i++) {
				System.out.println("*** Method Signature: " +
			                        method[i].toString());
			}
			Class<?> superClass = c.getSuperclass();
			System.out.println("The name of the superclass is " +
									superClass.getName());
			Method superMethod[] = superClass.getDeclaredMethods();
			System.out.println("The superclass has: ");
			for (int i = 0; i < superMethod.length; i++) {
				System.out.println("*** Method Signature: " + 
									superMethod[i].toString());
				System.out.println("      Return type: " +  
									superMethod[i].getReturnType().getName());
			}
			Field[] fields = c.getFields();
			for (int i = 0; i < fields.length; i++) {
				String name = fields[i].getName();
				String type = fields[i].getType().getName();
				System.out.println("Creating an instance of Employee");
				Object obj = c.newInstance();
				Object value = fields[i].get(obj);
				System.out.println("Field Name: " + name + ", Type: " + 
									type + " Value: " + value.toString());
				Method raiseSalary = c.getMethod("raiseSalary", null);
				System.out.println("Using method invoke(): ");
				raiseSalary.invoke(c.newInstance(), null);
				Class<?> parameterTypes[] = new Class[]{String.class};
				Method myMethod = c.getMethod("changeAddress", parameterTypes);
				
				Object arguments[] = new Object[1];
				arguments[0] = "250 Broadway";
				myMethod.invoke(c.newInstance(), arguments);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
