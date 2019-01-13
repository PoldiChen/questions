package question094;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket serverSocket;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public Server() {}
	
	public void start() {
		try {
			serverSocket = new ServerSocket(10000); // ¼àÌýµÄ¶Ë¿Ú
			System.out.println("server start,wait for connection...");
			while (true) {
				socket = serverSocket.accept();
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);
				String line = in.readLine();
				System.out.println("the input is:" + line);
				out.close();
				in.close();
				socket.close();
				if (line.equals("quit")) {
					System.out.println("server shutdown.");
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}

}
