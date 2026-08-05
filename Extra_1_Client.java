import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true);

        Scanner sc = new Scanner(System.in);

        String message;

        while (true) {

            System.out.print("Enter Message: ");
            message = sc.nextLine();

            out.println(message);

            System.out.println("Server: " + in.readLine());

            if (message.equalsIgnoreCase("bye"))
                break;
        }

        socket.close();
        sc.close();
    }
}
