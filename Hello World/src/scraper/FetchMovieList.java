package scraper;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FetchMovieList {

	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("http://www.imdb.com/list/ls055386972/")
					.userAgent("Googlebot").get();
			Elements temp = doc.select("div.info");
			int i = 0;
			for(Element movieList : temp){
				i++;
				System.out.println(i + " " + movieList.getElementsByTag("a").first().text());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
