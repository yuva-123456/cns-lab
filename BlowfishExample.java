import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class BlowfishExample {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Plain Text: ");
        String text = sc.nextLine();

        System.out.print("Enter Secret Key: ");
        String key = sc.nextLine();

        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "Blowfish");

        Cipher cipher = Cipher.getInstance("Blowfish");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(text.getBytes());
        String encryptedText = Base64.getEncoder().encodeToString(encrypted);

        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedText));

        System.out.println("\nEncrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + new String(decrypted));

        sc.close();
    }
}
