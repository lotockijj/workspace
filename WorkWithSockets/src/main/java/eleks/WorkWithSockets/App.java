package eleks.WorkWithSockets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class App{

	public static void main(String[] args) throws IOException {

		startServer();
		startSender();
	}

	public static void startSender() {
		(new Thread() {
			Socket s;
			@Override
			public void run() {
				try {
					s = new Socket("localhost", 60114);
					BufferedWriter out = new BufferedWriter(
							new OutputStreamWriter(s.getOutputStream()));
					Scanner scanner = new Scanner(System.in);
					while (!(Thread.currentThread().isInterrupted())) {
						String str = scanner.nextLine();
						out.write(str);
						out.newLine();
						out.flush();
					}
					scanner.close();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally{
					
				}
			}
		}).start();
	}

	public static void startServer() {
		(new Thread() {
			@Override
			public void run() {
				ServerSocket ss;
				try {
					ss = new ServerSocket(60114);

					Socket s = ss.accept();

					BufferedReader in = new BufferedReader(
							new InputStreamReader(s.getInputStream()));
					String line = null;
					while ((line = in.readLine()) != null) {
						System.out.println(line);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}