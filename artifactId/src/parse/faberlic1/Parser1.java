package parse.faberlic1;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.itextpdf.awt.geom.gl.Crossing.CubicCurve;

public class Parser1 {

	static int i = 1; 
	static int count = 0;
	private static Goods currentGoods;;
	List<Goods> listGoods;
	String sName;
	//Goods currentGoods;

	// PRIVATE 
	private final Path fFilePath;
	private final static Charset ENCODING = StandardCharsets.UTF_8;  

	String discount;
	int page;
	String article;
	String name;
	BigDecimal priceCatalog;
	BigDecimal theSame;
	String allowance;
	BigDecimal priceStore;
	float ballConsultant;
	BigDecimal priceBuyer;
	float ballBuyer;

	/**
	   Constructor.
	   @param aFileName full name of an existing, readable file.
	 */
	public Parser1(String aFileName){
		fFilePath = Paths.get(aFileName);
	}

	public static void main(String... aArgs) throws IOException {
		Parser1 parser = new Parser1("E:\\Faberlic\\pieces\\1.txt");
		Parser1 parser2 = new Parser1("E:\\Faberlic\\pieces\\2.txt");
		currentGoods = new Goods();
		parser.processLineByLine();
		System.out.println("Number line: " + count);
		log("Done.");

		parser2.processDocumentText();

		System.out.println(parser.currentGoods);
		System.out.println("Number line: " + count);
	}

	/** Template method that calls {@link #processLine(String)}.  */
	public final void processLineByLine() throws IOException {
		try (Scanner scanner =  new Scanner(fFilePath, ENCODING.name()); Scanner scanner2 = new Scanner(fFilePath, "windows-1251")){
			while (scanner.hasNextLine() && scanner2.hasNextLine()){
				processLine(scanner.nextLine());
				System.out.println("Before");
				processLine2(scanner2.nextLine());
				System.out.println("After");
				break;
			}      
		}
	}
	/**Second template method that calls {@link #processLine2(String)}. */
		public final void processDocumentText() throws IOException{
			try(Scanner scanner = new Scanner(fFilePath, "windows-1251")){
				while(scanner.hasNextLine()){
					processLine2(scanner.nextLine());
				}
			}
		}

	/** 
	   Overridable method for processing lines in different ways.

	   <P>This simple default implementation expects simple name-value pairs, separated by an 
	   '=' sign. Examples of valid input: 
	   <tt>height = 167cm</tt>
	   <tt>mass =  65kg</tt>
	   <tt>disposition =  "grumpy"</tt>
	   <tt>this is the name = this is the value</tt>
	 */
	protected void processLine(String aLine){
		//use a second Scanner to parse the content of each line 
		Scanner scanner = new Scanner(aLine);
		scanner.useDelimiter("\\s+");
		if (scanner.hasNext()){
			//assumes the line has a certain structure
			//			String txt = "";
			//			for(int i = 0; i < 7; i++){
			//				txt += scanner.next() + " | ";
			//			}
			//			log(txt);
			currentGoods.setPriceCatalog(scanner.nextBigDecimal());
			currentGoods.setTheSame(scanner.nextBigDecimal());
			currentGoods.setAllowance(scanner.next()); // val.toString()).setScale(2,RoundingMode.HALF_UP).doubleValue()
			currentGoods.setPriceStore(new BigDecimal(Double.parseDouble(String.valueOf(scanner.next()).replace(",", "."))).setScale(2, RoundingMode.HALF_UP));
			currentGoods.setBallConsultant(scanner.nextFloat());
			currentGoods.setPriceBuyer(new BigDecimal(Double.parseDouble(String.valueOf(scanner.next()).replace(",", "."))));
			currentGoods.setBallBuyer(scanner.nextFloat());
			//log("Number 1: " + quote(n1.trim()) + "  Number 1: " + quote(n2.trim()));
			scanner.close();
		}
		else {
			log("Empty or invalid line. Unable to process.");
		}
	}

	protected void processLine2(String aLine) throws UnsupportedEncodingException{
		Scanner scaner = new Scanner(aLine);
		scaner.useDelimiter("\n\r");// 

		if(scaner.hasNext()){

			if(i == 1){
				scaner.useDelimiter("\\s+"); // whitespace;

				currentGoods.setDiscount(scaner.next());
				System.out.println(currentGoods.getDiscount());
				//				String s = logWithReturnValue(scaner.next());
				//				System.out.println(s);

				currentGoods.setPage(scaner.nextInt());
				System.out.println(currentGoods.getPage());
				//				String s2 = logWithReturnValue(scaner.next());
				//				System.out.println(s2);
				i++;
			}
			if(i == 2){
				sName = scaner.next();
				System.out.println("Inside process line 2" + " sName: " + sName );
				String ss = ""; 
				Pattern pattern = Pattern.compile("(\\d\\d\\d\\d)");
				Matcher matcher = pattern.matcher(sName);
				while(matcher.find()){
					ss = matcher.group();
					System.out.println(matcher.group() + "  *******************************");
				}
				log(ss);
				currentGoods.setArticle(ss);
				System.out.println(currentGoods.getArticle());
			}
			if(i == 3){
				currentGoods.setName(sName + ": " + scaner.next());
				System.out.println(sName);
				//log(scaner.next());
			}
			i++;
		}
		scaner.close();
	}

	private static void log(Object aObject){
		System.out.println(String.valueOf(aObject).replace(",", "."));
		count++; 
	}

	private static String logWithReturnValue(Object aObject){
		return String.valueOf(aObject);
	}

	private String quote(String aText){
		String QUOTE = "'";
		return QUOTE + aText + QUOTE;
	}

	private String decoder(String s) throws UnsupportedEncodingException{
		//String myString = "some cyrillic text";
		//		byte bytes[] = s.getBytes("ISO-8859-1"); 
		//		String value = new String(bytes, "UTF-8"); 


		//String myString = "some cyrillic text";
		byte bytes[] = s.getBytes("UTF-8"); 
		String value = new String(bytes, "UTF-8"); 

		//String value = new String(s.getBytes("UTF-8"), "ASCII");

		//String value = new String(s.getBytes("CP850"), "ISO-8859-1");

		//String value = new String(s.getBytes(), "UTF-8");

		//String value = new String(s.getBytes("CP850"), "ISO-8859-1");

		//		byte[] bytes = s.getBytes("ISO-8859-1");
		//		UniversalDetector encDetector = new UniversalDetector(null);
		//		encDetector.handleData(bytes, 0, bytes.length);
		//		encDetector.dataEnd();
		//		String encoding = encDetector.getDetectedCharset();
		//		if (encoding != null) s = new String(bytes, encoding);
		return value;
	}
} 
