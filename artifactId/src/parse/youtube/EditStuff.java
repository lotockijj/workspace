package parse.youtube;

import java.io.FileOutputStream;
import java.util.Map;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class EditStuff {

	public static void main(String[] args) {
		try{
			PdfReader reader = new PdfReader("Fonts.pdf");
			
			System.out.println(reader.isTampered());
			PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("Fonts2.pdf"));
			System.out.println(reader.isTampered());
			
			Map<String, String> info = reader.getInfo();
			
			info.put("Author", "Taras Shevchenko");
			info.put("Title", "Will");
			info.put("Subject", "poetry");
			
			stamper.setMoreInfo(info);
			stamper.close();
		} catch(Exception e){
			System.out.println(e);
		}
		
	}

}
