
/**
 *
 * @author kan
 */
import java.net.*;
import java.io.*;

public class Messaging extends Thread {

    private Socket clientSocket;

    Messaging(Socket client) {
        this.clientSocket = client;
    }

    @Override()
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));

            PrintWriter out = new PrintWriter(this.clientSocket.getOutputStream(), true);

            while (true) {
                String msg = in.readLine();
                System.out.println("Message : " + msg);
                out.println(currentThread().getName() + " Ack : " + msg);
                if (msg.equals("exit")) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
