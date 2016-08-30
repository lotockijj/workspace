package yakov.fain.lesson18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WebSiteReader {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		String nextLine;
		URL url = null;
		URLConnection urlConn = null;

		InputStreamReader inStream = null;
		BufferedReader buff = null;
		//index.html or index.jsp or some other default URL at google;
		try{
			url = new URL("http://www.google.com");
			urlConn = url.openConnection();

			inStream = new InputStreamReader(urlConn.getInputStream(), "UTF8");

			buff = new BufferedReader(inStream);
			
//				URL url = new URL("http://www.google.com");
//				InputStream in = url.getInputStream();
//				Buff= new BufferedReader(new InputStreamReader(in));

			while(true){
				nextLine = buff.readLine();
				if(nextLine != null){
					System.out.println(nextLine);
				} else {
					break;
				}

			}
		} catch (MalformedURLException e){
			System.out.println("Please check the URL" + e.toString());
		} catch (IOException e1){
			System.out.println("Can't read from the internet: " + e1.toString());
		}
		finally {
			if(inStream != null){
				try{
					inStream.close();
					buff.close();
				} catch (IOException e1){
					System.out.println("Can't close stream and buffer: " + e1.getMessage());
				}
			}
		}

	}

}
