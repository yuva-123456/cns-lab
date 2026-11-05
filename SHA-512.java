import java.security.MessageDigest;
import java.util.Scanner;

public class prog7A {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        byte[] digest = md.digest(text.getBytes("UTF-8"));

        StringBuilder result = new StringBuilder();

        for (byte b : digest) {
            result.append(String.format("%02x", b & 0xff));
        }

        System.out.println("SHA-512 Digest: " + result);

        sc.close();
    }
}
