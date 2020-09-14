
/**
 *
 * @author kan
 */
package DatePingServer;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        var client = new Socket("localhost", 8080);
        var in = new Scanner(client.getInputStream());
        System.out.println("Server Date : " + in.nextLine());
    }

}
