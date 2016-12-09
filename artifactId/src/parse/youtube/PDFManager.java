package parse.youtube;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class PDFManager {

	private PDFParser parser;
	private PDFTextStripper pdfStripper;
	private PDDocument pdDoc ;
	private COSDocument cosDoc ;

	private String Text ;
	private String filePath;
	private File file;

	public PDFManager() {

	}

	public String ToText() throws IOException{
		this.pdfStripper = null;
		this.pdDoc = null;
		this.cosDoc = null;

		file = new File(filePath);
		parser = new PDFParser(new FileInputStream(file)); // update for PDFBox V 2.0

		parser.parse();
				cosDoc = parser.getDocument();
				pdfStripper = new PDFTextStripper();
				pdDoc = new PDDocument(cosDoc);
				pdDoc.getNumberOfPages();
				pdfStripper.setStartPage(1);
				pdfStripper.setEndPage(10);

				// reading text from page 1 to 10
				// if you want to get text from full pdf file use this code
				// pdfStripper.setEndPage(pdDoc.getNumberOfPages());

				Text = pdfStripper.getText(pdDoc);
				return Text;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public static void main(String[] args) {
		String nextLine;

		PDFManager pdfManager = new PDFManager();
		pdfManager.setFilePath("E:\\Faberlic\\15_2016.pdf");

		File file = new File("faberlic.txt");

		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			//FileReader fileReader = new FileReader(file.getAbsolutePath());
			//BufferedReader bufferedReader = new BufferedReader(fileReader);
//			
			FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
			fileWriter.write(pdfManager.ToText());
//			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//			bufferedWriter.write(pdfManager.ToText());
//			bufferedWriter.close();

//			while(true){
//				nextLine = pdfManager.T;
//				if(nextLine != null){
//					System.out.println(nextLine);           
//				} else {
//					break;
//				}
//			}
			System.out.println(pdfManager.ToText());
			System.out.println("\nDONE!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
