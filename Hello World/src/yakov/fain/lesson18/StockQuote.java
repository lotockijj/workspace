package yakov.fain.lesson18;

import java.net.*;
import java.io.*;
import java.util.StringTokenizer;

public class StockQuote {

	static void printStockQuote(String symbol){
		String csvString;
		URL url = null;
		URLConnection urlConn = null;
		InputStreamReader inStream = null;
		BufferedReader buff = null;
		try{
			url = new URL("http://quote.yahoo.com/d/quotes.csv?s="
					+ symbol + "&f=sl1d1t1c1ohgv&e=.csv");
			urlConn = url.openConnection();
			inStream = new InputStreamReader(urlConn.getInputStream());
			buff = new BufferedReader(inStream);
			// get the quote as a csv string
			csvString =buff.readLine();
			// parse the csv string
			StringTokenizer tokenizer = new StringTokenizer(csvString, ",");
			String ticker = tokenizer.nextToken();
			String price = tokenizer.nextToken();
			String tradeDate = tokenizer.nextToken();
			String tradeTime = tokenizer.nextToken();
			System.out.println("Symbol: " + ticker +
					" Price: "+ price + " Date: " + tradeDate
					+ " Time: " + tradeTime);
		} catch(MalformedURLException e){
			System.out.println("Please check the spelling of "
					+ "the URL: " + e.toString() );
		} catch(IOException e1){
			System.out.println("Can’t read from the Internet: " + e1.toString() );
		}finally{
			try{
				inStream.close();
				buff.close();
			}catch(Exception e){
				System.out.println("StockQuote: can’t close streams" + 
						e.getMessage());
			}
		}
	}
	public static void main(String args[]){
		if (args.length==0){
			System.out.println("Sample Usage: java StockQuote IBM");
			System.exit(0);
		}
		printStockQuote(args[0]);
	}
}