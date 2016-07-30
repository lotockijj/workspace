package serialization.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Save obj = new Save();
		obj.i = 4;
		
		File f = new File("Obj.txt");
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(obj);
		
		FileInputStream fis = new FileInputStream("Obj.txt");
		ObjectInputStream ois= new ObjectInputStream(fis);
		Save obj2 = (Save) ois.readObject();
		System.out.println("Value of obj2 = " + obj2.i);

	}

}

