package parse.youtube;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class WorkingWithFonts {

	public static void main(String[] args) throws DocumentException, FileNotFoundException {
		Document doc = new Document();
		
		Font[] fonts = {
				new Font(),
				new Font(Font.FontFamily.COURIER, 18, Font.BOLD, 
						new BaseColor(/*red*/ 0, /*green*/ 0, /* blue*/0)),
				new Font(Font.FontFamily.TIMES_ROMAN, 22, Font.ITALIC, new BaseColor(0, 255, 0))
		};
		
		PdfWriter.getInstance(doc, new FileOutputStream("Fonts.pdf"));
		doc.open();
		for (int i = 0; i < fonts.length; i++) {
			doc.add(new Paragraph("The Font Family is: " + fonts[i].getFamilyname() +
					". The Font Size is: " + fonts[i].getSize(), 
					fonts[i]));
		}
		doc.close();
	}
}
