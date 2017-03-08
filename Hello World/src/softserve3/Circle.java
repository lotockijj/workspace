package softserve3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class Circle implements Serializable{
	private double radius;

	//constructors, getters, setters goes here

	public double getCircleLength() {
		return 2 * Math.PI * radius;
	}

	public double getSquare() {
		return Math.PI * radius * radius;
	}

	public class Cylider extends Circle {
		private double height;

		@Override
		public double getSquare() {
			return 2 * super.getSquare() + height * getCircleLength();
		}
	}

//	public List readCollectionFromFile(String filePath) {
//		try {
//			FileInputStream fis = new FileInputStream(filePath);
//			ObjectInputStream ois = new ObjectInputStream(fis);
//			List resultList = (ArrayList) ois.readObject();
//			ois.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			throw new RuntimeException();
//		}
//	}
	public void writeCollectionToFile(String filePath) {
		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
//			oos.writeObject(list);
//			oos.writeObject(r1);
			oos.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
