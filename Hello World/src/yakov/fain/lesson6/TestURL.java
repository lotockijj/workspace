package yakov.fain.lesson6;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class TestURL {
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		try {
			java.net.URL myURL = new java.net.URL ("http://www.acme.com");
			System.out.println("myURL.getAuthority() - " + myURL.getAuthority()); 
			System.out.println("myURL.getFile() -   " + myURL.getFile());
			System.out.println("myURL.getHost() -   " + myURL.getHost());
			System.out.println("myURL.toExternalForm() -  " + myURL.toExternalForm());
			System.out.println("myURL.getPort() -  " + myURL.getPort());
			System.out.println("myURL.getProtocol() -  " + myURL.getProtocol());
			System.out.println("myURL.getDefaultPort() -  " + myURL.getDefaultPort());
			System.out.println("myURL.getPath() -  " + myURL.getPath());
			System.out.println("myURL.getQuery()-  " + myURL.getQuery());
			System.out.println("myURL.getRef() - " + myURL.getRef());
			System.out.println("myURL.getUserInfo()-  " + myURL.getUserInfo());
			System.out.println("myURL.toExternalForm()- " + myURL.toExternalForm());
			System.out.println("myURL.toURI()- " + myURL.toURI());
			System.out.println("myURL.toString()-  " + myURL.toString());
			System.out.println("myURL.openConnection()- " + myURL.openConnection());
		} catch (MalformedURLException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
}
