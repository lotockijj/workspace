package yakov.fain.lesson18;

import java.io.*;
import java.net.*;

public class Client { // you must specify args like IBM or TOM etc. 
	
	public static void main(String[] args) {
		if (args.length==0){
			System.out.println("Usage: java Client Symbol");
			System.exit(0);
		}
		OutputStream outbound = null;
		BufferedReader inbound = null;
		Socket clientSocket = null;
		try {
			// Open a client socket connection
			clientSocket = new Socket("localhost", 3000);
			System.out.println("Client: " + clientSocket);
			// Get the streams
			outbound = clientSocket.getOutputStream();
			inbound=new BufferedReader(new
					InputStreamReader(clientSocket.getInputStream()));
			// Send stock symbol to the server
			outbound.write((args[0]+"\n").getBytes());
			outbound.write("End\n".getBytes());
			String quote;
			while (true){
				quote = inbound.readLine();
				if (quote.equals("End")){
					break;
				}
				System.out.println("Got the quote for " + args[0]+":" + quote);
			}
		}catch (UnknownHostException uhe){
			System.out.println("UnknownHostException: " + uhe);
		} catch (IOException ioe){
			System.err.println("IOException: " + ioe);
		} finally{
			// Close the streams
			try{
				outbound.close();
				inbound.close();
				clientSocket.close();
			} catch(IOException e){
				System.out.println("Can not close streams..." +
						e.getMessage());
			}
		}
	}
}