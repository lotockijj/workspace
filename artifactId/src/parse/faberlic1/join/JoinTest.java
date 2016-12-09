package parse.faberlic1.join;

import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import parse.faberlic1.Goods;

public class JoinTest {

	static int i = 0; 
	static int count = 0;
	private static Goods currentGoods;;
	List<Goods> listGoods;
	static String sName;

	public static void main(String[] args) {

		Path fPath2 = Paths.get("E:\\Faberlic\\pieces\\2.txt");
		try(Scanner scanner2 = new Scanner(fPath2, "windows-1251")){
			while(scanner2.hasNextLine()){
				processLine2(scanner2.nextLine());
				i++; 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void processLine2(String aLine) throws UnsupportedEncodingException{
		Scanner scaner = new Scanner(aLine);
		scaner.useDelimiter("\n\r");// 
		while(scaner.hasNext()){
			scaner.useDelimiter("\\s+"); // whitespace;
			if(i%3 == 0){
				System.out.println(scaner.next());
				System.out.println(Integer.parseInt(scaner.nextLine().trim()));
			}
			//			if(i == 2){
			//				System.out.print(scaner.nextLine());
			//				i = 0;
			//			}
			//			break;
			//			String ss = ""; 
			//			Pattern pattern = Pattern.compile("(\\d\\d\\d\\d)");
			//			Matcher matcher = pattern.matcher(sName); 
			//			while(matcher.find()){
			//				ss = matcher.group();
			//				System.out.print(ss + " ");
			//			}
			//			
			//			currentGoods.setName(sName + ": " + scaner.next()); //System.out.println("\n" + sName);
		}
		scaner.close();
	}
}
