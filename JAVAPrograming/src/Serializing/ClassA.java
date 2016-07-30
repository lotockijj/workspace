package Serializing;
import java.io.*;
	class ClassA {
		public static void main(String args[]){
				Employee emp = new Employee();
				emp.lName = “John”;
				emp.fName = “Smith”;
				emp.salary = 50000;
				FileOutputStream fOut=null;
				ObjectOutputStream oOut=null;
				try{ 
					fOut = new FileOutputStream(“c:\\1\\BestEmployee.ser”);
					oOut = new ObjectOutputStream(fOut);
					oOut.writeObject(emp); //serializing employee
				} catch (IOException e){
					// close the streams
					try{
						oOut.flush();
						oOut.close();
						fOut.close();
					}catch (IOException ioe){
						ioe.printStackTrace();
					}
				}
				System.out.println(“The Employee Object has been serialized into “ +
						“c:\\practicalJava\\BestEmployee.ser”);
		}
}