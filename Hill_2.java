import java.util.*;

public class HillCipher{
        static int[][] key = {
                {3, 3},
                {2, 5}
        };
        static int[][] ikey = {
                {15, 17},
                {20, 9}
        };
        static String encrypt( String text ){
                if ( text.length() %2 != 0 ) text += "X";
                StringBuilder sb = new StringBuilder();
                for ( int i = 0; i < text.length(); i += 2){
                        int a = text.charAt(i) - 'A';
                        int b = text.charAt(i+1) - 'A';
                        int e1 = ( key[0][0] * a + key[0][1] * b ) % 26;
                        int e2 = ( key[1][0] * a + key[1][1] * b ) %26;
                        sb.append((char) (e1 + 'A'));
                        sb.append((char) (e2 + 'A'));
                }
                return sb.toString();
        }
        static String decrypt( String text ){
                StringBuilder sb = new StringBuilder();
                for ( int i = 0; i < text.length(); i += 2){
                        int a = text.charAt(i) - 'A';
                        int b = text.charAt(i+1) - 'A';
                        int d1 = ( ikey[0][0] * a + ikey[0][1] * b ) % 26;
                        int d2 = ( ikey[1][0] * a + ikey[1][1] * b ) %26;
                        sb.append((char) (d1 + 'A'));
                        sb.append((char) (d2 + 'A'));
                }
                return sb.toString();
        }
        public static void main(String args[]){
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter Plain Text(Upper): ");
                String s = sc.nextLine().toUpperCase();
                String e = encrypt(s);
                String d = decrypt(e);
                System.out.println("\nOriginal Text: "+ s);
                System.out.println("Encrypted Text: "+ e);
                System.out.println("Decrypted Text: "+ d);
                sc.close();
        }
}
