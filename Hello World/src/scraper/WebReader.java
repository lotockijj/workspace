package scraper;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebReader {

	public static void main(String[] args) throws IOException{
		String address = "http://www.tais-lviv.com/ua/contact.php";
		URL pageLocation = new URL(address);
		Scanner in = new Scanner(pageLocation.openStream());
		while(in.hasNext()){
			String line = in.next();
			if(line.contains("href=\"http://")){
				int from = line.indexOf("\"");
				int to = line.lastIndexOf("\"");
				System.out.println(line.substring(from + 1, to));
			}
		}
		in.close();
	}
	//http://hewyork.craigslist.org/search/jjj
	//https://smart-web-data-scraper.en.softonic.com/
	//www.soccerstats.com
}
