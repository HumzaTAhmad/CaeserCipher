import java.util.*;

public class CaeserCipher {

    public static void main(String arg[]) {
        Scanner keyboard = new Scanner(System.in);
        char[] table = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                't', 'u', 'v', 'w', 'x', 'y', 'z' };
        System.out.println("Would you like to encrypt or decrypt?");
        String choice = keyboard.nextLine().toLowerCase();

        if (choice.toString().equals("encrypt")) {
            System.out.println("What message would you like to encrypt?");
            String message = keyboard.nextLine().toLowerCase();
            System.out.println("What would you like the key to be? Enter a number from 1-26");
            int key = keyboard.nextInt();
            if (key < 1 || key > 26) {
                System.out.println("NOT A VALID KEY");
                System.exit(1);
            }
            System.out.println("ENCRYPTED MESSAGE: \n" + "-> " + Encrypt(key, message, table));
        } else if (choice.toString().equals("decrypt")) {
            System.out.println("What encrypted message would you like to decrypt?");
            String message = keyboard.nextLine().toLowerCase();
            System.out.println("What is the key? Enter a number from 1-26");
            int key = keyboard.nextInt();
            if (key < 1 || key > 26) {
                System.out.println("NOT A VALID KEY");
                System.exit(1);
            }
            System.out.println("THE ACTUAL MESSAGE: \n" + "-> " + Decrypt(key, message, table));
            System.out.println("THE 26 POSSIBLE DECRYPTIONS");
            for (int i = 1; i <= 26; i++) {
                System.out.println(
                        i + ". " + Decrypt(i, message, table));
            }
        } else {
            System.out.println("NOT A VALID OPTION");
        }
    }

    public static String Encrypt(int key, String message, char[] table) {
        String encryptedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            char L = message.charAt(i);
            for (int j = 0; j < table.length; j++) {
                if (L == table[j]) {
                    L = (table[(j + key) % 26]);
                    encryptedMessage = encryptedMessage + L;
                    break;
                } else if (L == ' ') {
                    encryptedMessage = encryptedMessage + " ";
                    break;
                }
            }
        }
        return encryptedMessage;
    }

    public static String Decrypt(int key, String message, char[] table) {
        String decryptedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            char L = message.charAt(i);
            for (int j = 0; j < table.length; j++) {
                if (L == table[j]) {
                    L = (table[Math.floorMod((j - key), 26)]);
                    decryptedMessage = decryptedMessage + L;
                    break;
                } else if (L == ' ') {
                    decryptedMessage = decryptedMessage + " ";
                    break;
                }
            }
        }
        return decryptedMessage;
    }
}
