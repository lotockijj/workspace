package parse.youtube;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Utilities;

public class PDF {

	public static void main(String[] args) {
		
		Document document = new Document();
		Rectangle rect = new Rectangle(PageSize.LETTER.rotate());
//		Rectangle rect = new Rectangle(Utilities.millimetersToPoints(100), 
//				Utilities.millimetersToPoints(200));
		document.setPageSize(rect);
		
		try{
			PdfWriter.getInstance(document, 
					new FileOutputStream("Super Awesome Document.pdf"));
			document.open();
			Paragraph paragraph = new Paragraph();
			paragraph.add("This is super awesome!");
			document.add(paragraph);
			document.close();
			System.out.println("Created");
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
