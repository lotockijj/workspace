package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpr {

	public static void main(String[] args) {
		Pattern pat;
		Matcher mat;
		boolean found;

		pat = Pattern.compile("java");
		mat = pat.matcher("java"); 
		found = mat.matches();

		System.out.println("Testing java against java");
		if(found) System.out.println("Matches");
		else System.out.println("No match");

		System.out.println();

		System.out.println("Testing java against java 8");
		mat = pat.matcher("java 8"); // create new matcher

		found = mat.matches();

		if(found) System.out.println("Matches");
		else System.out.println("No match");
	}
}
