package yakov.fain.lesson24.wolkthrough;

import java.lang.reflect.Method;

public class DBParamProcessor {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		String processingClass = "yakov.fain.lesson24.wolkthrough.MyDBWorker";
		
		Class<?> loadedClass = Class.forName(processingClass);
		Method methods[] = loadedClass.getMethods();
		for(Method m : methods){
			if(m.isAnnotationPresent(DBParams.class)){
				DBParams dbAnnotation = m.getAnnotation(DBParams.class);
				System.out.println("Method: " + m.getName() + 
				"\nParams of MyDBWorker are:\n" + "dbName=" + dbAnnotation.dbName() + "\n"	+
				"uid=" + dbAnnotation.uid() + "\n" + "password=" + dbAnnotation.password() +"\n");
				
			}
		}
	}

	
}
