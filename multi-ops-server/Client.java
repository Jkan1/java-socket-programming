
/**
 *
 * @author kan
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String args[]) {
        try {
            Socket client = new Socket("localhost", 8080);
            System.out.println("Enter lines of text then Ctrl+D or Ctrl+C to quit");
            Scanner userInput = new Scanner(System.in);
            Scanner input = new Scanner(client.getInputStream());
            PrintWriter output = new PrintWriter(client.getOutputStream(), true);
            while (userInput.hasNextLine()) {
                output.println(userInput.nextLine());
                System.out.println(input.nextLine());
            }
            client.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
