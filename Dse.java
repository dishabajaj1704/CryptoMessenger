public class Dse {
    public static void main(String[] args) {
        HelperFunctions helper = new HelperFunctions();
        final String plainText = "0123456789ABCDEF";
        final String key = "133457799BBCDFF1";

        GenerateKeys generateKey = new GenerateKeys(key, helper);
        ComputeRound computeRound = new ComputeRound(plainText, generateKey, helper, generateKey.getRoundKeys());
        String lastRound[] = computeRound.getLastRoundText();
        System.out.println("Message:- " + plainText);
        System.out.println("Key:- " + key);
        Encryption encryption = new Encryption(lastRound, helper);
        System.out.println("Encrypted Text:- " + encryption.getEncryptedHexaText());
        Decryption decryption = new Decryption(generateKey, helper, encryption);
        System.out.println("Decrypted Text:- " + decryption.getDecryptedText());

    }
}
