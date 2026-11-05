import java.util.*;

public class CeaserCipher {
        public static void main (String args[]){
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter Plain Text(Uppercase) : ");
                String s = sc.nextLine().toUpperCase();
                System.out.println("Enter key value : ");
                int k = sc.nextInt();
                String encrypt = "";
                String decrypt = "";
                for ( char ch : s.toCharArray()){
                        if ( ch >= 'A' && ch <= 'Z')
                                encrypt += (char)((ch - 'A' + k) % 26 + 'A'>
                        else encrypt += ch;
                }
                for (char ch : encrypt.toCharArray()){
                        if ( ch >= 'A' && ch <= 'Z')
                                decrypt += (char)((ch - 'A' - k + 26) % 26 >
                        else decrypt += ch;
                }
                System.out.println("Encrypted Text : " + encrypt);
                System.out.println("Decrypted Text : " + decrypt);
                sc.close();
        }
}
