package yakov.fain.lesson7tryit;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class CreateFileAndWriteToHim {

	public static void main(String[] args) throws UnsupportedEncodingException, 
									FileNotFoundException, IOException {

		try(Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("myFile.txt"), "utf - 8"))){
			writer.write("something");
		}
	}
	
}