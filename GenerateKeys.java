import java.util.ArrayList;
import java.util.HashMap;

public class GenerateKeys {
    String key;
    String binaryOfKey = "";
    HelperFunctions helper;
    int[][] pc1Matrix;
    ArrayList<String[]> leftShiftlist = new ArrayList<>();
    String pc1Key = "";
    private ArrayList<String> roundKeys = new ArrayList<>();

    GenerateKeys(String key, HelperFunctions helper) {
        this.helper = helper;
        this.key = key;
        this.binaryOfKey = helper.convertHexToBinary(key);
        pc1();

    }

    public void pc1() {
        pc1Matrix = new int[8][7];
        int[][] temp1 = helper.permutation(1);
        /** REPLACING RANDOM NUMBER WITH ACTUAL BITS */
        for (int i = 0; i < temp1.length; i++) {
            for (int j = 0; j < temp1[0].length; j++) {
                // System.out.println((temp1[i][j]) - 1);
                int n = temp1[i][j];
                n = n - 1;
                this.pc1Key += Character.getNumericValue((this.binaryOfKey.charAt(n)));
            }
        }
        leftCircularShift(this.pc1Key);
        // pc1Matrix = helper.permutation(binaryOfKey, 1);
        // for (int i = 0; i < pc1Matrix.length; i++) {
        // for (int j = 0; j < pc1Matrix[0].length; j++) {
        // System.out.print(pc1Matrix[i][j] + " ");
        // }
        // System.out.println();
        // }

    }

    public void leftCircularShift(String pc1Key) {
        HashMap<Integer, Integer> leftShiftTable = helper.getLeftShiftTable();
        // String pc1Key = helper.getPc1Key();
        String arr[] = helper.splitInHalf(pc1Key);
        leftShiftlist.add(arr);
        for (int i = 1; i <= 16; i++) {
            int previousIndex = (i - 1);
            int numberOfShifts = leftShiftTable.get(i);
            String prevArr[] = leftShiftlist.get(previousIndex);
            String Cprev = prevArr[0];
            String Dprev = prevArr[1];

            String Csubstr = Cprev.substring(0, numberOfShifts);
            String Dsubstr = Dprev.substring(0, numberOfShifts);

            String Cnext = Cprev.substring(numberOfShifts) + Csubstr;
            String Dnext = Dprev.substring(numberOfShifts) + Dsubstr;

            String tempArr[] = new String[2];
            tempArr[0] = Cnext;
            tempArr[1] = Dnext;

            leftShiftlist.add(tempArr);
            // System.out.println("C" + i + "-->" + Cnext);
            // System.out.println("D" + i + "-->" + Dnext);

        }

        pc2(leftShiftlist);
    }

    public void pc2(ArrayList<String[]> leftShiftlist) {
        int temp2[][] = helper.permutation(2);

        for (int round = 1; round <= 16; round++) {
            String temp[] = leftShiftlist.get(round);
            String tempKey = temp[0] + temp[1];
            String roundKey = "";
            for (int i = 0; i < temp2.length; i++) {
                for (int j = 0; j < temp2[0].length; j++) {
                    int n = temp2[i][j];
                    n = n - 1;
                    roundKey += Character.getNumericValue((tempKey.charAt(n)));
                }

            }

            roundKeys.add(roundKey);

        }

    }

    public ArrayList<String> getRoundKeys() {
        return this.roundKeys;
    }

}
