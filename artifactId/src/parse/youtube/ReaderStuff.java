package parse.youtube;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.itextpdf.text.pdf.PdfReader;

public class ReaderStuff {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		PdfReader reader = new PdfReader(new FileInputStream("Fonts.pdf"));
		System.out.println("PDF Version: " + reader.getPdfVersion());
		System.out.println("Number of Pages: " + reader.getNumberOfPages());
		System.out.println("File Length: " + reader.getFileLength());
		System.out.println("Width of Page 1: " + reader.getPageSize(1).getWidth());
		System.out.println("Height of Page 1: " + reader.getPageSize(1).getHeight());
		System.out.println("Rotation of Page 1: " + reader.getPageRotation(1));

	}

}
