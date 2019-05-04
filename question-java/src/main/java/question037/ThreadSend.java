package question037;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * @author poldi.chen
 * @className ThreadSend
 * @description TODO
 * @date 2019/5/4 13:04
 **/
public class ThreadSend implements Runnable {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    private int port;

    public ThreadSend(int port) {
        this.port = port;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        try {
            System.out.println("client start,input something to send:");
            socket = new Socket("127.0.0.1", port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            while (true) {
                BufferedReader line = new BufferedReader(new InputStreamReader(System.in));
                out.println(line.readLine());
//                line.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
