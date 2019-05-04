package question037;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author poldi.chen
 * @className ThreadReceive
 * @description TODO
 * @date 2019/5/4 13:04
 **/
public class ThreadReceive implements Runnable {

    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader inn;
    private PrintWriter outt;

    private int port;

    public ThreadReceive(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port); // 监听的端口
            System.out.println("server start,wait for connection...");

            while (true) {
                socket = serverSocket.accept();
                inn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                outt = new PrintWriter(socket.getOutputStream(), true);
                String line = inn.readLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
