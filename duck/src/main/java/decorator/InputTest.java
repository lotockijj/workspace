package decorator;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {

	public static void main(String[] args) throws IOException {
		int c;

		File file = new File("testDecorator.txt");

		if(file.createNewFile()){ // create the file
			System.out.println("File is created.");
		} else {
			System.out.println("File already exists.");
		}

		System.out.println("Path - " + file.getAbsolutePath());

		FileWriter writer = new FileWriter(file); // write content
		writer.write("I know the Decorator Pattern therefore I RULE!");
		writer.close();

		try {
			InputStream in =
					new LowerCaseInputStream(
							new BufferedInputStream(
									new FileInputStream("testDecorator.txt")));
			while((c = in.read()) >= 0) {
				System.out.print((char)c);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
