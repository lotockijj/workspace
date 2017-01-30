package parse.faberlic1.join;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import parse.faberlic1.Goods;

public class Join {

	static int i = 0; 
	static int count = 0;
	private Goods currentGoods;
	static List<Goods> listGoods;
	static String sName;

	String discount;
	String page;
	String article;
	String name;
	BigDecimal priceCatalog;
	BigDecimal theSame;
	String allowance;
	BigDecimal priceStore;
	float ballConsultant;
	BigDecimal priceBuyer;
	float ballBuyer;

	public static void main(String[] args) throws IOException {
		Join join = new Join();
		join.currentGoods = new Goods();
		listGoods = new ArrayList<>();
		
		
		Path fPath = Paths.get("E:\\Faberlic\\pieces\\1.txt");
		Path fPath2 = Paths.get("E:\\Faberlic\\pieces\\2.txt");
		
		try(Scanner scanner = new Scanner(fPath, "windows-1251"); 
				Scanner scanner2 = new Scanner(fPath2, "windows-1251")){
			while(scanner2.hasNextLine()){
				i++;
				join.processLine2(scanner2.nextLine());
				if(i == 3){
					join.processLine(scanner.nextLine());
					i = 0;
					
					join.currentGoods = new Goods(join.currentGoods.getDiscount(), 
							join.currentGoods.getPage(), join.currentGoods.getArticle(), 
							join.currentGoods.getName(), join.currentGoods.getPriceCatalog(), 
							join.currentGoods.getTheSame(), join.currentGoods.getAllowance(), 
							join.currentGoods.getPriceStore(), join.currentGoods.getBallConsultant(), 
							join.currentGoods.getPriceBuyer(), join.currentGoods.getBallBuyer());
					listGoods.add(join.currentGoods);
					join.currentGoods = null;
					join.currentGoods = new Goods();
				}
				//System.out.println(join.currentGoods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i = 0; i < listGoods.size(); i++){
			System.out.println(listGoods.get(i));
		}
	}

	private void processLine(String aLine){
		Scanner scanner = new Scanner(aLine);
		scanner.useDelimiter("\\s+");
		if (scanner.hasNext()){
			currentGoods.setPriceCatalog(scanner.nextBigDecimal()); //System.out.print(currentGoods.getPriceCatalog() + " ");
			currentGoods.setTheSame(scanner.nextBigDecimal()); //System.out.print(currentGoods.getTheSame() + " ");
			currentGoods.setAllowance(scanner.next()); //System.out.print(currentGoods.getAllowance() + " "); // val.toString()).setScale(2,RoundingMode.HALF_UP).doubleValue()
			currentGoods.setPriceStore(new BigDecimal(Double.parseDouble(String.valueOf(scanner.next()).replace(",", "."))).setScale(2, RoundingMode.HALF_UP)); //System.out.print(currentGoods.getPriceStore() + " ");
			currentGoods.setBallConsultant(scanner.nextFloat()); //System.out.print(currentGoods.getBallConsultant() + " ");
			currentGoods.setPriceBuyer(new BigDecimal(Double.parseDouble(String.valueOf(scanner.next()).replace(",", "."))).setScale(2, RoundingMode.HALF_UP)); //System.out.print(currentGoods.getPriceBuyer() + " ");
			currentGoods.setBallBuyer(scanner.nextFloat()); //System.out.println(currentGoods.getBallBuyer() + " ");
			
			scanner.close();
		}
	}

	private void processLine2(String aLine) throws UnsupportedEncodingException{
		Scanner scaner = new Scanner(aLine);
		scaner.useDelimiter("\n\r");// 

		while(scaner.hasNext()){

			if(i == 1){
				scaner.useDelimiter("\\s+"); // whitespace;
				currentGoods.setDiscount(scaner.next()); System.out.println(currentGoods.getDiscount());
				currentGoods.setPage(scaner.next().trim()); System.out.println(currentGoods.getPage());
			}
			if(i == 2){
				sName = scaner.nextLine(); System.out.print(sName + " ");
				String ss = ""; 
				Pattern pattern = Pattern.compile("\\d\\d\\d\\d");
				Matcher matcher = pattern.matcher(sName); 
				while(matcher.find()){
					ss += " " +  matcher.group();
				}
				currentGoods.setArticle(ss);
			}
			if(i == 3) currentGoods.setName(sName + ": " + scaner.nextLine()); //System.out.println(sName);
		}
		scaner.close();
	}
}

//Scanner scannerTest = new Scanner(fPath2, "windows-1251");
//while(scannerTest.hasNext()){
//	System.out.println(scannerTest.nextLine());
//}
//System.exit(0);

