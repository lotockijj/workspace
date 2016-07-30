package Socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	static ServerSocket serverSocket;
	static Socket socket;
	static DataOutputStream out;

	public static void main(String[] args) throws IOException {
		System.out.println("Start server...");
		serverSocket = new ServerSocket(7777);
		System.out.println("Server started...");
		socket = serverSocket.accept();
		System.out.println("Connection from: " + socket.getInetAddress());
		out.writeUTF("Test my cocket!!! -------");
		System.out.println("Data has been sent!");
	}
}
