
/**
 *
 * @author kan
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server Listening");
            ExecutorService pool = Executors.newFixedThreadPool(20);
            while (true) {
                pool.execute(new Operation(server.accept()));
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static class Operation implements Runnable {

        private Socket socket;

        Operation(Socket socket) {
            this.socket = socket;
        }

        @Override()
        public void run() {
            System.out.println("New Client Connected : " + socket);
            try {
                Scanner input = new Scanner(socket.getInputStream());
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                while (input.hasNextLine()) {
                    output.println(input.nextLine().toUpperCase());
                }
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
