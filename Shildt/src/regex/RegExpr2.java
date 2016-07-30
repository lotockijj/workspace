package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpr2 {
	public static void main(String[] args) {
		Pattern pat = Pattern.compile("java");
		Matcher mat = pat.matcher("java 8");

		System.out.println("Looking for java in java 8.");
		
		if(mat.find()) System.out.println("Subseguence found");
		else System.out.println("No match");
	}
}
