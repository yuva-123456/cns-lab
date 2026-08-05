import java.util.Scanner;

public class HillCipher {

    static int[][] key = {
        {3, 3},
        {2, 5}
    };

    static int[][] inverseKey = {
        {15, 17},
        {20, 9}
    };

    static String encrypt(String text) {
        if (text.length() % 2 != 0)
            text += "X";

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i += 2) {
            int a = text.charAt(i) - 'A';
            int b = text.charAt(i + 1) - 'A';

            int e1 = (key[0][0] * a + key[0][1] * b) % 26;
            int e2 = (key[1][0] * a + key[1][1] * b) % 26;

            result.append((char) (e1 + 'A'));
            result.append((char) (e2 + 'A'));
        }

        return result.toString();
    }

    static String decrypt(String text) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i += 2) {
            int a = text.charAt(i) - 'A';
            int b = text.charAt(i + 1) - 'A';

            int d1 = (inverseKey[0][0] * a + inverseKey[0][1] * b) % 26;
            int d2 = (inverseKey[1][0] * a + inverseKey[1][1] * b) % 26;

            result.append((char) (d1 + 'A'));
            result.append((char) (d2 + 'A'));
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Plain Text (Uppercase): ");
        String plain = sc.next().toUpperCase();

        String encrypted = encrypt(plain);
        String decrypted = decrypt(encrypted);

        System.out.println("\nOriginal Text : " + plain);
        System.out.println("Encrypted Text: " + encrypted);
        System.out.println("Decrypted Text: " + decrypted);

        sc.close();
    }
}
