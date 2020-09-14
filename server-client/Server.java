
/**
 *
 * @author kan
 */
package ServerClient;

import java.io.*;
import java.net.*;

public class Server {

    public static void main(String args[]) {

        try {
            ServerSocket socket = new ServerSocket(4000);

            System.out.println("Waiting for Client");
            Socket client = socket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            while (true) {
                String msg = in.readLine();
                System.out.println("Message : " + msg);
                out.println("Ack : " + msg);
                if (msg.equals("exit")) {
                    break;
                }
            }
            
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
