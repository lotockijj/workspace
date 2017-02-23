package parse.faberlic1.join;

import java.io.IOException;
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

// Completely work for first discount!!!

public class JoinNext {
	int i = 0; 
	int count = 0;
	private Goods currentGoods;;
	List<Goods> listGoods;
	String sName;

	public void createPathAndScanner(){
		Path fPath = Paths.get("E:\\Faberlic\\15_2016adapter.txt");
		currentGoods = new Goods();
		listGoods = new ArrayList<>();
		try(Scanner scanner = new Scanner(fPath, "windows-1251")){
			while(scanner.hasNextLine()){
				i++;
				if(i == 1) currentGoods = new Goods();
				processLine(scanner.nextLine());
			}
			scanner.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public void createPathAndScanner2(){
		Path fPath = Paths.get("E:\\Faberlic\\15_2016adapter22.txt");
		currentGoods = new Goods();
		listGoods = new ArrayList<>();
		try(Scanner scanner = new Scanner(fPath, "windows-1251")){
			while(scanner.hasNextLine()){
				i++;
				if(i == 1) currentGoods = new Goods();
				processLine2(scanner.nextLine());
			}
			scanner.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	private void processLine(String aLine) {
		Scanner scanner = new Scanner(aLine);
		scanner.useDelimiter("\\s+"); // whitespace;

		if(i == 1){
			while(scanner.hasNext()){
				currentGoods.setDiscount(scanner.next()); //System.out.println(currentGoods.getDiscount());
				currentGoods.setPage(scanner.next().trim()); //System.out.println(currentGoods.getPage());
			}
		}
		if(i == 2){
			sName = scanner.nextLine();
			currentGoods.setName(sName); //System.out.println(currentGoods.getName());
			String ss = "";
			Pattern pattern = Pattern.compile("\\d\\d\\d\\d");
			Pattern pattern2 = Pattern.compile("\\d\\d\\d\\d\\d");
			Matcher matcher = pattern.matcher(sName);
			Matcher matcher2 = pattern2.matcher(sName);
			while(matcher.find()){
				ss += matcher.group() + ", ";
			}
			int j = 0;
			while(matcher2.find()){
				if(j == 0){
					ss = ""; 
				}
				j++;
				ss += matcher2.group() + ", ";
			}
			ss = removeLastCharAndYears(ss);
			currentGoods.setArticle(ss); //System.out.println(currentGoods.getArticle());
		}
		if(i == 3){
			while(scanner.hasNext()){
				currentGoods.setPriceCatalog(scanner.nextBigDecimal()); //System.out.print(currentGoods.getPriceCatalog() + " ");
				currentGoods.setTheSame(scanner.nextBigDecimal()); //System.out.print(currentGoods.getTheSame() + " ");
				currentGoods.setAllowance(scanner.next()); //System.out.print(currentGoods.getAllowance() + " "); // val.toString()).setScale(2,RoundingMode.HALF_UP).doubleValue()
				currentGoods.setPriceStore(new BigDecimal(Double.parseDouble(String.valueOf(scanner.next()).replace(",", "."))).setScale(2, RoundingMode.HALF_UP)); //System.out.print(currentGoods.getPriceStore() + " ");
				currentGoods.setBallConsultant(scanner.nextFloat()); //System.out.print(currentGoods.getBallConsultant() + " ");
				currentGoods.setPriceBuyer(new BigDecimal(Double.parseDouble(String.valueOf(scanner.next()).replace(",", "."))).setScale(2, RoundingMode.HALF_UP)); //System.out.print(currentGoods.getPriceBuyer() + " ");
				currentGoods.setBallBuyer(scanner.nextFloat()); //System.out.println(currentGoods.getBallBuyer() + " ");
				listGoods.add(currentGoods);
				i = 0;
			}
		}
		scanner.close();
	}
	
	private void processLine2(String aLine) {
		Scanner scanner = new Scanner(aLine);
		scanner.useDelimiter("\\s+"); // whitespace;

		if(i == 1){
			while(scanner.hasNext()){
				String ss = scanner.next();
				if(Character.isLetter(ss.charAt(0))){
					currentGoods.setDiscount(ss);
					currentGoods.setPage(scanner.next());
				} else {
					currentGoods.setDiscount(null);
					currentGoods.setPage(ss);
				}
			}
		}
		if(i == 2){
			currentGoods.setArticle(scanner.next());
			String name = "";
			while(scanner.hasNext()){
				name += scanner.next() + " ";
			}
			currentGoods.setName(name);
		}
		if(i == 3){
			while(scanner.hasNext()){
				currentGoods.setPriceCatalog(scanner.nextBigDecimal()); //System.out.print(currentGoods.getPriceCatalog() + " ");
				currentGoods.setTheSame(scanner.nextBigDecimal()); //System.out.print(currentGoods.getTheSame() + " ");
				currentGoods.setAllowance(scanner.next()); //System.out.print(currentGoods.getAllowance() + " "); // val.toString()).setScale(2,RoundingMode.HALF_UP).doubleValue()
				currentGoods.setPriceStore(new BigDecimal(Double.parseDouble(String.valueOf(scanner.next()).replace(",", "."))).setScale(2, RoundingMode.HALF_UP)); //System.out.print(currentGoods.getPriceStore() + " ");
				currentGoods.setBallConsultant(scanner.nextFloat()); //System.out.print(currentGoods.getBallConsultant() + " ");
				currentGoods.setPriceBuyer(new BigDecimal(Double.parseDouble(String.valueOf(scanner.next()).replace(",", "."))).setScale(2, RoundingMode.HALF_UP)); //System.out.print(currentGoods.getPriceBuyer() + " ");
				currentGoods.setBallBuyer(scanner.nextFloat()); //System.out.println(currentGoods.getBallBuyer() + " ");
				listGoods.add(currentGoods);
				i = 0;
			}
		}
		scanner.close();
	}

	private String removeLastCharAndYears(String ss) {
		if(ss != null){
			ss = ss.replace("2016", "  ");
			return ss.substring(0, ss.length() - 2).trim();
		}
		return null;
	}

	public static void main(String[] args) {
//		JoinNext myJoin = new JoinNext();
//		myJoin.createPathAndScanner();
		
//		myJoin.createPathAndScanner2();
//				for(Goods goods : myJoin.listGoods){
//					System.out.println(goods);
//				}
//				System.out.println(myJoin.listGoods.size());
//		JoinNext myJoin2 = new JoinNext();
//		try{
//			myJoin2.createPathAndScanner2();
//		} catch (Exception e){
//			System.out.println(e);
//		}
//		for(Goods goods: myJoin2.listGoods){
//			System.out.println(goods);
//		}
				JoinNext2 join = new JoinNext2();
				try {
					join.createPathAndScanner();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				join.writeListTestIntoFile();
	}
}
