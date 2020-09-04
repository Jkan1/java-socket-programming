
/**
 *
 * @author kan
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

    public static void main(String args[]) throws InterruptedException {

        try {
            Socket client = new Socket("localhost", 4000);

            System.out.println("Connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            Scanner userInput = new Scanner(System.in);
            String msg;
            do {
                System.out.println("Enter Message To Send:");
                msg = userInput.nextLine();

                out.println(msg);

                String response = in.readLine();
                System.out.println(response);

            } while (!msg.equals("exit"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
