package question094;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;


public class Client {
	
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public Client() {}
	
	public void start() {
		try {
			System.out.println("client start,input something to send:");
			socket = new Socket("127.0.0.1", 10000);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			BufferedReader line = new BufferedReader(new InputStreamReader(System.in));
			out.println(line.readLine());
			line.close();
			out.close();
			in.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		client.start();
	}

}
