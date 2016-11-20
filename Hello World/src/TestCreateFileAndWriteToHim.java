import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class TestCreateFileAndWriteToHim {

	public static void main(String[] args) throws UnsupportedEncodingException, 
							FileNotFoundException, IOException{

		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("filename.txt"), "utf-8"))) {
			writer.write("something");
		}
		File f = new File("aaa.txt");
		System.out.println(f.getPath());
		System.out.println(f.getAbsolutePath());
		
	}

}
