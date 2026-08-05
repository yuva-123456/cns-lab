import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server Started...");
        System.out.println("Waiting for Client...");

        Socket socket = server.accept();
        System.out.println("Client Connected.");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true);

        String message;

        while (true) {

            message = in.readLine();

            System.out.println("Client: " + message);

            out.println(message);

            if (message.equalsIgnoreCase("bye"))
                break;
        }

        socket.close();
        server.close();

        System.out.println("Connection Closed.");
    }
}
