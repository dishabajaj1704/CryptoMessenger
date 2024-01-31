import java.util.ArrayList;

public class Decryption {
    GenerateKeys generateKeys;
    ArrayList<String> roundKeys;
    HelperFunctions helper;
    Encryption encryption;
    String lastRound[];
    String decrypted_text="";

    Decryption(GenerateKeys generateKeys, HelperFunctions helper, Encryption encryption) {
        this.generateKeys = generateKeys;
        this.roundKeys = this.generateKeys.getRoundKeys();
        this.helper = helper;
        this.encryption = encryption;
        decryptCypherText();
    }

    public void decryptCypherText() {
        ArrayList<String> roundKeys = generateKeys.getRoundKeys();
        ArrayList<String> reverseOfRoundKeys = new ArrayList<>();
        for (int i = 15; i >= 0; i--) {
            reverseOfRoundKeys.add(roundKeys.get(i));
        }

        String encryptedHexText = encryption.getEncryptedHexaText();
        ComputeRound cmpr = new ComputeRound(encryptedHexText, generateKeys, helper, reverseOfRoundKeys);
        String lastRound[] = cmpr.getLastRoundText();

        encryption = new Encryption(lastRound, helper);
        this.decrypted_text = encryption.getEncryptedHexaText();
    }

    public String getDecryptedText(){
        return  this.decrypted_text;
    }

}
