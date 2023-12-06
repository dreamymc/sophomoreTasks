import java.util.Scanner;

public class myMain {
    public static void main(String[] _dreamymc) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the word to be encrypted: ");
        String s = scan.nextLine();
        System.out.print("Enter the key: ");
        int k = scan.nextInt();
        logronioCipher encrypt = new logronioCipher();
        System.out.println("After the encryption: " + encrypt.encrypted(s, k));
        scan.close();
    }
}
