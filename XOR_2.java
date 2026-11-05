import java.util.*;

public class XORDEMO{
        public static void main (String args[]){
                Scanner sc = new Scanner(System.in);
                String s = "Hello World";
                System.out.println("String : " + s);
                System.out.println("\nCharacter\tXOR(0)\tAND(127)");
                System.out.println("---------------------------");
                for ( int i = 0; i < s.length(); i ++){
                        char ch = s.charAt(i);
                        System.out.println(ch +"\t\t"+(char)(ch^0)+"\t\t"+(char)(ch&127));
                }
        }
}
