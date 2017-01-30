package parse.faberlic1.join;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import parse.faberlic1.Goods;

public class JoinNext2 {
	int i = 0; 
	int count = 0;
	private Goods currentGoods;;
	List<Goods> listGoods; List<String> listTest;
	List<String> goods;
	String sName;
	String ss = new String();
	int m = 0;

	public void createPathAndScanner() throws IOException{
		//Path fPath = Paths.get("E:\\Faberlic\\15_2016adapter22.txt");
		Path fPath = Paths.get("E:\\Faberlic\\test2.txt");
		currentGoods = new Goods();
		listGoods = new ArrayList<>();
		goods = new ArrayList<>();

		FileWriter fw = new FileWriter("E://Faberlic//testNext.txt", true);
		try(Scanner scanner = new Scanner(fPath, "windows-1251")){
			while(scanner.hasNextLine()){
				if(goods.size() == 0){
					goods = new ArrayList<>();
				}
				processLine(scanner.nextLine());
			}
			for(String sL : listTest){
				parseAndCreateListOfGoods(sL);
			}
			for(String sL : listTest){
				System.out.println(sL);
				new BufferedWriter(fw).write(sL);
				new BufferedWriter(fw).newLine();
			}
			new BufferedWriter(fw).close();
			scanner.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	private void parseAndCreateListOfGoods(String sL) {
		Scanner scanner = new Scanner(sL);
		List<String> goodsString = new ArrayList<>();
		currentGoods = new Goods();
		while(scanner.hasNext()){
			goodsString.add(scanner.next());
		}
		setCurrentGoodsPriceBall(goodsString, currentGoods);
		StringBuilder discount = new StringBuilder();
		while(isFirstCharacterLetter(goodsString.get(0))){
			discount.append(goodsString.get(0) + " ");
			goodsString.remove(0);
		} 
		currentGoods.setDiscount(discount.toString()); //System.out.println(currentGoods.getDiscount());
		currentGoods.setPage(goodsString.get(0)); //System.out.println(currentGoods.getPage());
		goodsString.remove(0);
		currentGoods.setArticle(goodsString.get(0)); //System.out.println(currentGoods.getArticle());
		goodsString.remove(0);
		StringBuilder name = new StringBuilder();
		for(String n : goodsString){
			name.append(n + " ");
		}
		currentGoods.setName(name.toString()); //System.out.println(currentGoods.getName());
		listGoods.add(currentGoods);
		System.out.println(currentGoods);
		currentGoods = null;
		scanner.close();
	}

	private boolean isFirstCharacterLetter(String string) {
		return Character.isLetter(string.charAt(0));
	}

	private void setCurrentGoodsPriceBall(List<String> goodsString, Goods currentGoods2) {
		currentGoods2.setBallBuyer(Float.parseFloat(goodsString.get(goodsString.size() - 1).replace(",", "."))); //System.out.println(currentGoods.getBallBuyer());
		goodsString.remove(goodsString.size() - 1);
		currentGoods2.setPriceBuyer(new BigDecimal(Double.parseDouble(String.valueOf(goodsString.get(goodsString.size() - 1)).replace(",", "."))).setScale(2, RoundingMode.HALF_UP));//System.out.println(currentGoods.getPriceBuyer());
		goodsString.remove(goodsString.size() - 1);
		currentGoods2.setBallConsultant(Float.parseFloat(goodsString.get(goodsString.size() - 1).replace(",", "."))); //System.out.println(currentGoods.getBallConsultant());
		goodsString.remove(goodsString.size() - 1);
		currentGoods2.setPriceStore(new BigDecimal(Double.parseDouble(String.valueOf(goodsString.get(goodsString.size() - 1)).replace(",", "."))).setScale(2, RoundingMode.HALF_UP)); //System.out.println(currentGoods.getPriceStore());
		goodsString.remove(goodsString.size() - 1);
		currentGoods2.setAllowance(goodsString.get(goodsString.size() - 1));//System.out.println(currentGoods.getAllowance());
		goodsString.remove(goodsString.size() - 1);
		currentGoods2.setTheSame(new BigDecimal(goodsString.get(goodsString.size() - 1)));//System.out.println(currentGoods.getTheSame());
		goodsString.remove(goodsString.size() - 1);
		currentGoods2.setPriceCatalog(new BigDecimal(goodsString.get(goodsString.size() - 1)));//System.out.println(currentGoods.getPriceCatalog());
		goodsString.remove(goodsString.size() - 1);

	}

	private void processLine(String aLine) {
		Scanner scanner = new Scanner(aLine);
		scanner.useDelimiter("\\s+"); // whitespace;

		while(scanner.hasNext()){
			goods.add(scanner.next());
		}
		if(checkIfLastSevenElementIsnumber(goods)){
			for(int j = 0; j < goods.size(); j++){
				ss += goods.get(j) + " ";
			}
			listTest.add(ss);
			ss = "";
			goods.removeAll(goods);
		}
		scanner.close();
	}

	private boolean checkIfLastSevenElementIsnumber(List<String> goods2) {
		int countNumbers = 0;
		for(int i = goods2.size() - 1; i >= 0; i--){
			char c = goods.get(i).charAt(0);
			if(Character.isDigit(c)){
				countNumbers++;
				if(countNumbers == 7){
					return true;
				}
			} else {
				countNumbers = 0;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		JoinNext2 join = new JoinNext2();
		join.createPathAndScanner();
	}
}
