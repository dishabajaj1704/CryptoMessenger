import java.util.Scanner;

public class Dse {
    public static void main(String[] args) {
        HelperFunctions helper = new HelperFunctions();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a message");
        String message = sc.nextLine();

        System.out.println("Enter a Key");
        String key = sc.nextLine();

        if (key.length() != 16) {
            while ((key.length() * 4) % 64 != 0) {
                key += '0';
            }
        }
        String hexaString = helper.stringToHex(message);
        String hexKey = helper.stringToHex(key);

        if (hexaString.length() % 64 == 0) {
            System.out.println("Non Padded String:- " + hexaString);
        } else {
            while ((hexaString.length() * 4) % 64 != 0) {
                hexaString += '0';
            }
        }
        String plainText = hexaString;
        String encryptedText = "";
        String decryptedHexaText = "";
        String decryptedText = "";
        for (int i = 0; i < hexaString.length(); i += 16) {
            GenerateKeys generateKey = new GenerateKeys(hexKey, helper);
            ComputeRound computeRound = new ComputeRound(plainText.substring(i, i + 16), generateKey, helper,
                    generateKey.getRoundKeys());
            String lastRound[] = computeRound.getLastRoundText();
            Encryption encryption = new Encryption(lastRound, helper);
            encryptedText += encryption.getEncryptedHexaText();
            Decryption decryption = new Decryption(generateKey, helper, encryption);
            decryptedHexaText += decryption.getDecryptedText();
        }

        decryptedText = helper.hexToString(decryptedHexaText);
        System.out.println("Message:- " + message);
        System.out.println("Encrypted Text:" + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);

    }
}
