import java.io.*;
import java.net.*;

public class UpperServer {

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

            if (message.equalsIgnoreCase("bye")) {
                out.println("bye");
                break;
            }

            String upper = message.toUpperCase();

            System.out.println("Client: " + message);

            out.println(upper);
        }

        socket.close();
        server.close();

        System.out.println("Connection Closed.");
    }
}
