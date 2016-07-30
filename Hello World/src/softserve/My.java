package softserve;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.*;

public class My {

	public static <T> void main(String[] args) throws UnsupportedEncodingException, 
	FileNotFoundException, IOException{

		ArrayList<Employee1> coll = new ArrayList<Employee1>();

		EmployeeHourlyWage a = new EmployeeHourlyWage("Edd", "Goo", 23, 4);
		EmployeeHourlyWage b = new EmployeeHourlyWage("Tedd", "Foo", 2, 5);
		EmployeeHourlyWage c = new EmployeeHourlyWage("Bob", "Bee", 4, 2);
		EmployeeHourlyWage d = new EmployeeHourlyWage("Kate", "See", 2, 5);
		
		EmployeeFixedPayment e = new EmployeeFixedPayment("Lisunia", "Lee", 7, 500);
		EmployeeFixedPayment f = new EmployeeFixedPayment("Mike", "Ree", 13, 1000);
		EmployeeFixedPayment g = new EmployeeFixedPayment("Izia", "Kurz", 13, 1000);
		EmployeeFixedPayment j = new EmployeeFixedPayment("Aisha", "Moore", 20, 800);

		coll.add(a);
		coll.add(b);
		coll.add(c);
		coll.add(d);
		coll.add(e);
		coll.add(f);
		coll.add(g);
		coll.add(j);

		Collections.sort(coll, Employee1.idOrNameComparator);
		
		String str = "Test.xml";
		File file = new File(str);
		String absolutePathOfFirstFile = file.getAbsolutePath();
		FileInputStream fileInputStream = new FileInputStream(absolutePathOfFirstFile);
		System.out.println("absolutePathOf - " + absolutePathOfFirstFile.toString());

		try(Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("myFile.txt"), "utf-8"))){
			for (Employee1 i : coll) {
				System.out.println(i);
				System.out.println(i.getMonthlySalary());
				writer.write(i.toString() +  i.getMonthlySalary());
			} 
		}
		

		try(FileInputStream myFile = new FileInputStream("myFile.txt"); 
				BufferedInputStream buff = new BufferedInputStream(myFile)){
			boolean eof = false;
			while(!eof){
				int biteValue = buff.read();
				System.out.print(biteValue + " ");
				if(biteValue == -1){
					eof = true;
				}
			} 
		} catch(IOException e1){
			System.out.println(e1);
		}
		
	}
}
