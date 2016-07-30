package yakov.fain.lesson17;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ClassB {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		FileInputStream fis = new FileInputStream("text.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Employee obj = (Employee) ois.readObject();
		System.out.println("Our employee - " + obj.toString());
	}

}
