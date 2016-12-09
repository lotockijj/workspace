package regex;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestHarness {
	static String line;
	static String line2;

	public static void main(String[] args){

		while(true){
			System.out.println("Enter your regex: ");
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
				line = bufferedReader.readLine();
				System.out.println("Enter input string to search:");
				BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(System.in));
				line2 = bufferedReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			int x = 0; 
			while (x != 1) {

				Pattern pattern = 
						Pattern.compile(line);

				Matcher matcher = 
						pattern.matcher(line2);

				boolean found = false;
				while (matcher.find()) {
					System.out.format("I found the text" +
							" \"%s\" starting at " +
							"index %d and ending at index %d.%n",
							matcher.group(),
							matcher.start(),
							matcher.end());
					found = true;
					x = 1;
				}
				if(!found){
					System.out.format("No match found.%n");
					break;
				}
			}
		}
	}
}