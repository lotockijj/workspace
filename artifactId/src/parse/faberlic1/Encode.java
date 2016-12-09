package parse.faberlic1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class Encode {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("E:\\Faberlic\\faberlictxt.txt");
		InputStreamReader isr = new InputStreamReader(fis, "windows-1251");
		
		String defaultEncoding = isr.getEncoding();
		System.out.println(defaultEncoding);
		
		Reader in = new BufferedReader(isr);
		
		FileOutputStream fos = new FileOutputStream("E:\\Faberlic\\outfaberlictxt.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		Writer out = new BufferedWriter(osw);
		
		int ch;
		while((ch = in.read()) > -1){
			out.write(ch);
		}
		out.close();
		in.close();
	}

}
