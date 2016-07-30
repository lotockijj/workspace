package softserve2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Lesson5.Rectangle;

public class Square extends Rectangle {

	private static String list;
	private static Object r1;

	Square(float side) {
		super();
	}


	public static void sortAndPrint() {
		List<Rectangle> list = new ArrayList<Rectangle>();

		Rectangle r1 = new Rectangle();
		Square s1 = new Square(5);
		Rectangle r2 = new Rectangle();
		Square s2 = new Square(6);

		list.add(r1);
		list.add(r2);
		list.add(s1);
		list.add(s2);

		System.out.println("list = " + list);
		Collections.sort(list, new Comparator<Rectangle>() {
			public int compare(Rectangle r1, Rectangle r2) {
				return (int) Math.signum(r1.getArea() - r2.getArea());
			}
		});

		float i = 0;
		i++;
		double d = 0;
		d++;
		Double d2 = 0d;
		d2++;
		long l = 0;
		l++;
		char c = 'a';
		c++;



		System.out.println("Area sorted list = " + list);

		Collections.sort(list, (rr1, rr2)
				-> Float.compare(rr1.getArea(), rr2.getArea()));

		Collections.sort(list, new Comparator<Rectangle>() {
			public int compare(Rectangle r1, Rectangle r2) {
				return (int) Math.signum(r1.getPerimeter() - r2.getPerimeter());
			}
		});
		System.out.println("Perimeter sorted list = " + list);
		System.out.println(list.get(0));
	}

	public static void main(String[] args) {
		sortAndPrint();
		try {
			// write object to file
			FileOutputStream fos = new FileOutputStream("mybean.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			System.out.println("list before serialization = " + list);
			oos.writeObject(list);
			oos.writeObject(r1);
			oos.close();
			// read object from file
			FileInputStream fis = new FileInputStream("mybean.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			List resultList = (ArrayList) ois.readObject();
			Rectangle resultR1 = (Rectangle) ois.readObject();
			System.out.println("Reading result list = " + resultList);
			System.out.println("Reading result r1 = " + resultR1);
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (StreamCorruptedException e) {
			System.out.println("File is not correct");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}