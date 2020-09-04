
/**
 *
 * @author kan
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class MultithreadedServer {

    public static void main(String args[]) {

        try {
            ServerSocket socket = new ServerSocket(4000);

            System.out.println("Server Started");

            while (true) {
                Socket client = socket.accept();
                System.out.println("Client Connected");
                Messaging connection = new Messaging(client);
                connection.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
