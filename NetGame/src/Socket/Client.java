package Socket;

import java.io.*;
import java.net.*;

public class Client {
	
	static Socket socket;
	static DataInputStream in; 

	public static void main(String[] args) {
		try{
		System.out.println("Connecting...");
		socket = new Socket("localhost", 7777);
		System.out.println("Connection successful.");
		in = new DataInputStream(socket.getInputStream());
		System.out.println("Receiving information.");
		String test = in.readUTF();
		System.out.println("Massage from server: " + test);
		} catch (Exception e){
			System.out.println(e);
		}
	}
}
