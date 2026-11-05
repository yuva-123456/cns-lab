import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.Base64;
import java.util.Scanner;

public class BlowFish {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter keystore password: ");
        char[] password = sc.nextLine().toCharArray();

        KeyStore ks = KeyStore.getInstance("JCEKS");

        try (FileInputStream fis = new FileInputStream("blowfish.jceks")) {
            ks.load(fis, password);
        }

        SecretKey key = (SecretKey) ks.getKey("blowfishkey", password);

        String message = "Hello world";

        Cipher cipher = Cipher.getInstance("Blowfish");

        // Encryption
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(message.getBytes("UTF-8"));

        String encryptedText = Base64.getEncoder().encodeToString(encrypted);

        System.out.println("Original Text: " + message);
        System.out.println("Encrypted Text: " + encryptedText);

        // Decryption
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(encrypted);

        System.out.println("Decrypted Text: " + new String(decrypted, "UTF-8"));

        sc.close();
    }
}


//Keytool command for password:
//"keytool -genseckey -alias blowfishkey -keyalg Blowfish -keysize 128 -keystore blowfish.jceks -storetype JCEKS"
//execute the keytool without any command before, just the direct above command
