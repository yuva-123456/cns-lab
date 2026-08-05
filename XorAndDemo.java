public class XorAndDemo {
    public static void main(String[] args) {
        String str = "Hello world";
        System.out.println("Original String: " + str);
        System.out.println("\nCharacter\tXOR with 0\tAND with 127");
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            char xorResult = (char) (ch ^ 0);
            char andResult = (char) (ch & 127);
            System.out.println(ch + "\t\t" + xorResult + "\t\t" + andResult);
        }
    }
}
