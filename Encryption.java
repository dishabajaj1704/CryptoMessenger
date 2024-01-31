public class Encryption {
    String lastRound[];
    HelperFunctions helper;
    private String hexaEncryptedText = "";
    private String encryptedBinaryText = "";

    Encryption(String lastRound[], HelperFunctions helper) {
        this.lastRound = lastRound;
        this.helper = helper;
        String swappedString = lastRound[1] + lastRound[0];
        int[][] inverseIp = helper.getInverseInitialPermutation(helper.permutation(3));
        encryptedBinaryText = getEncryptedBinaryText(inverseIp, swappedString);
        hexaEncryptedText = helper.convertBinaryToHexaDecimal(encryptedBinaryText);
    }

    public String getEncryptedBinaryText(int[][] inverseIp, String swappedString) {
        String encryptedBinaryText = "";
        for (int i = 0; i < inverseIp.length; i++) {
            for (int j = 0; j < inverseIp[0].length; j++) {
                int n = inverseIp[i][j];
                n = n - 1;
                encryptedBinaryText += Character.getNumericValue((swappedString.charAt(n)));

            }
        }

        return encryptedBinaryText;
    }

    public String getEncryptedHexaText() {
        return this.hexaEncryptedText;
    }

    public String getEncryptedBinaryText() {
        return this.encryptedBinaryText;
    }

}
