package com.faberlic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
			String ss = findingArticleAndSetAllArticles(sName);
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

	public String findingArticleAndSetAllArticles(String s){
		ArrayList<Integer> completeList = new ArrayList<>();
		completeList.addAll(tryAndCheckRegexTwoNumbersThoughDefis(s));
		Set<Integer> set = new HashSet<>();
		String str = "";
		for(int i = 0; i < completeList.size(); i++){
			set.add(completeList.get(i));
		} 
		List<Integer> sortedList = new ArrayList<>(set);
		Collections.sort(sortedList);
		for(int st : sortedList){
			str += st + ", ";
		}
		str = removeLastCharAndYears(str);
		return str;
	}

	//finding separate numbers like 1234 or 23444 etc.
	public ArrayList<Integer> findingSeparateNumbers(String str){
		ArrayList<Integer> list = new ArrayList<>();
		Pattern pattern = Pattern.compile("\\d\\d\\d\\d");
		Pattern pattern2 = Pattern.compile("\\d\\d\\d\\d\\d");
		Matcher matcher = pattern.matcher(str);
		Matcher matcher2 = pattern2.matcher(str);
		while(matcher.find()){
			list.add(Integer.parseInt(matcher.group()));
		}
		while(matcher2.find()){
			list.add(Integer.parseInt(matcher2.group()));
		}
		return list;
	}

	//test this in order to find and process: 12345-12349
	public ArrayList<Integer> tryAndCheckRegexTwoNumbersThoughDefis(String str){
		// a metacharacter to be treated as an ordinary character:
		//		precede the metacharacter with a backslash, or
		//		enclose it within \Q (which starts the quote) and \E (which ends it).
		ArrayList<Integer> list = new ArrayList<>();
		Pattern pattern3 = Pattern.compile("\\d\\d\\d\\d\\d\\-\\d\\d\\d\\d\\d");
		Matcher matcher3 = pattern3.matcher(str);
		str = deleteUsedPattern(pattern3, str);
		if(matcher3.find()){
			String stringFirstNumber = matcher3.group().substring(0, 5);
			String stringSecondNumber = matcher3.group().substring(6, 11);
			int firstNumber = Integer.parseInt(stringFirstNumber);
			int secondNumber = Integer.parseInt(stringSecondNumber);
			for(int i = firstNumber; i <= secondNumber; i++){
				list.add(i);
			}
		} 
		list.addAll(tryAndCheckRegexTwoNumbersThoughDefis2(str));
		list.addAll(findingSeparateNumbers(str));
		return list;
	}

	//test this in order to find and process: 1234-1238
	public ArrayList<Integer> tryAndCheckRegexTwoNumbersThoughDefis2(String str){
		ArrayList<Integer> list = new ArrayList<>();
		Pattern pattern = Pattern.compile("\\d\\d\\d\\d\\-\\d\\d\\d\\d");
		Matcher matcher = pattern.matcher(str);
		str = deleteUsedPattern(pattern, str);
		if(matcher.find()){
			String stringFirstNumber = matcher.group().substring(0, 4);
			String stringSecondNumber = matcher.group().substring(5, 9);
			int firstNumber = Integer.parseInt(stringFirstNumber);
			int secondNumber = Integer.parseInt(stringSecondNumber);
			for(int i = firstNumber; i <= secondNumber; i++){
				list.add(i);
			}
		}
		return list;
	}

	public String deleteUsedPattern(Pattern pt, String str){
		Matcher match = pt.matcher(str);
		while (match.find()) {
			String s = match.group();
			str = str.replaceAll( s, "");
		}
		return str;
	}
	
	private String removeLastCharAndYears(String ss) {
		if(ss != null){
			ss = ss.replace("2016", "  ");
			return ss.substring(0, ss.length() - 2).trim();
		}
		return null;
	}
	
	public void writeDataIntoDataBase(List<Goods> listTest){
		Properties p = new Properties();
		p.put("user", "root");
		p.put("password", "");
		p.put("dbUrl", "jdbc:mysql://localhost:3306/my_new_data_base"
				+ "?useUnicode=true&characterEncoding=utf-8");

		try(Connection myConn = DriverManager.getConnection((String) p.get("dbUrl"), p);
				PreparedStatement stmt = myConn.prepareStatement("insert into fab ("
						+ "discount, page, article, name, priceCatalog, theSame, allowance, "
						+ "priceStore, ballConsultant, priceBuyer, ballBuyer) "
						+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);")){
			for(int i = 0; i < listTest.size(); i++){
				stmt.setString(1, listTest.get(i).getDiscount());
				stmt.setString(2, listTest.get(i).getPage());
				stmt.setString(3, listTest.get(i).getArticle());
				stmt.setString(4, listTest.get(i).getName());

				stmt.setBigDecimal(5, listTest.get(i).getPriceCatalog());
				stmt.setBigDecimal(6, listTest.get(i).getTheSame());
				stmt.setString(7, listTest.get(i).getAllowance());
				stmt.setBigDecimal(8, listTest.get(i).getPriceStore());
				stmt.setFloat(9, listTest.get(i).getBallConsultant());
				stmt.setBigDecimal(10, listTest.get(i).getPriceBuyer());
				stmt.setFloat(11, listTest.get(i).getBallBuyer());

				stmt.executeUpdate();
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
