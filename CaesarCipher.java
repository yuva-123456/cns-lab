import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Plain Text: ");
        String text = sc.nextLine();

        System.out.print("Enter Key: ");
        int key = sc.nextInt();

        String encrypted = "";
        String decrypted = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch))
                    encrypted += (char) ((ch - 'A' + key) % 26 + 'A');
                else
                    encrypted += (char) ((ch - 'a' + key) % 26 + 'a');
            } else {
                encrypted += ch;
            }
        }
        for (int i = 0; i < encrypted.length(); i++) {
            char ch = encrypted.charAt(i);

            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch))
                    decrypted += (char) ((ch - 'A' - key + 26) % 26 + 'A');
                else
                    decrypted += (char) ((ch - 'a' - key + 26) % 26 + 'a');
            } else {
                decrypted += ch;
            }
        }

        System.out.println("\nEncrypted Text: " + encrypted);
        System.out.println("Decrypted Text: " + decrypted);

        sc.close();
    }
}
