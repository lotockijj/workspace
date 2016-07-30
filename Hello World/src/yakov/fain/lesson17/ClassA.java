package yakov.fain.lesson17;

import java.io.*;

class ClassA {
	

	public static void main(String args[]){
		
		Employee emp = new Employee("John", "Smith", 50000);
		
		FileOutputStream fOut=null;
		ObjectOutputStream oOut=null;
		
		File f = new File("text.txt");
		
		try{
			fOut = new FileOutputStream(f);
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
		System.out.println("The Employee object has been serialized into " +
				"text.txt");
	}
}