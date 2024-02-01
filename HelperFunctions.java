import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HelperFunctions {
    public String stringToHex(String input) {
        StringBuilder hexStringBuilder = new StringBuilder();

        for (char character : input.toCharArray()) {
            // Convert each character to its hexadecimal representation
            String hex = String.format("%01X", (int) character);
            hexStringBuilder.append(hex);
        }

        return hexStringBuilder.toString();
    }

    public String hexToString(String hexString) {
        // Convert hexadecimal string to a BigInteger
        BigInteger bigInt = new BigInteger(hexString, 16);

        // Convert BigInteger to a byte array
        byte[] bytes = bigInt.toByteArray();

        // Convert byte array to a string
        return new String(bytes);
    }

    public String convertHexToBinary(String input) {
        StringBuilder binaryBuilder = new StringBuilder();
        for (char c : input.toCharArray()) {
            /*
             * String s = Integer.toBinaryString(Character.digit(c, 16));
             * 
             * Character.digit(c, 16): This part takes a hexadecimal character c and
             * converts it to its decimal equivalent. The second parameter, 16, specifies
             * the base (hexadecimal in this case). For example, if c is 'A', the decimal
             * value is 10.
             * 
             * Integer.toBinaryString(...): This method then takes the decimal value
             * obtained from the previous step and converts it to its binary representation
             * as a string. For example, if the decimal value is 10, the binary string would
             * be "1010".
             */

            /*
             * String.format("%4s", binary).replace(' ', '0');
             * 
             * String.format("%4s", s): This part uses String.format to ensure that the
             * binary string binary has at least four characters by adding leading spaces if
             * needed. The format specifier "%4s" means to format the string with a minimum
             * width of 4 characters. For example, if s is "101", it will be formatted as
             * " 101".
             * 
             * .replace(' ', '0'): After formatting, this part replaces any space character
             * with a '0'. This is done to ensure that the final binary string has leading
             * zeros if necessary. For example, if the formatted string is " 101", it
             * becomes "0101" after this step.
             */
            String binary = Integer.toBinaryString(Character.digit(c, 16));
            String paddedBinary = String.format("%4s", binary).replace(' ', '0');
            binaryBuilder.append(paddedBinary);
        }
        return binaryBuilder.toString();
    }

    public int[][] permutation(int permutationType) {
        Random random = new Random();
        if (permutationType == 1) {

            Set<Integer> p1set = new HashSet<>();
            int pc1Matrix[][] = new int[8][7];
            // int temp[][] = new int[8][7];
            int min = 1;
            int max = 64;
            int[][] temp1 = {
                    { 57, 49, 41, 33, 25, 17, 9 },
                    { 1, 58, 50, 42, 34, 26, 18 },
                    { 10, 2, 59, 51, 43, 35, 27 },
                    { 19, 11, 3, 60, 52, 44, 36 },
                    { 63, 55, 47, 39, 31, 23, 15 },
                    { 7, 62, 54, 46, 38, 30, 22 },
                    { 14, 6, 61, 53, 45, 37, 29 },
                    { 21, 13, 5, 28, 20, 12, 4 },
            };
            return temp1;
            // for (int i = 0; i < temp.length; i++) {
            // for (int j = 0; j < temp[0].length; j++) {
            // int num = random.nextInt((max - min) + 1);
            // System.out.println("Num:- "+num);
            // while (p1set.contains(num) || num % 8 == 0) {
            // System.out.println("Num INSIDE:- " + num);
            // num = random.nextInt((max - min + 1)+min);
            // }

            // p1set.add(num);
            // temp[i][j] = num;

            // }
            // }

        } else if (permutationType == 2) {

            int min = 1;
            int max = 56;
            // int temp[][] = new int[8][6];
            Set<Integer> p2set = new HashSet<>();
            int[][] temp1 = {
                    { 14, 17, 11, 24, 1, 5 },
                    { 3, 28, 15, 6, 21, 10 },
                    { 23, 19, 12, 4, 26, 8 },
                    { 16, 7, 27, 20, 13, 2 },
                    { 41, 52, 31, 37, 47, 55 },
                    { 30, 40, 51, 45, 33, 48 },
                    { 44, 49, 39, 56, 34, 53 },
                    { 46, 42, 50, 36, 29, 32 },
            };

            // for (int i = 0; i < temp.length; i++) {
            // for (int j = 0; j < temp[0].length; j++) {
            // int num = random.nextInt((max - min) + 1);
            // System.out.println("Num:- "+num);
            // while (p2set.contains(num)) {
            // System.out.println("Num INSIDE:- " + num);
            // num = random.nextInt((max - min + 1)+min);
            // }

            // p2set.add(num);
            // temp[i][j] = num;

            // }
            // }
            return temp1;

        } else if (permutationType == 3) {
            int min = 1;
            int max = 64;
            // int temp[][] = new int[8][8];
            Set<Integer> ipset = new HashSet<>();
            int[][] temp1 = {
                    { 58, 50, 42, 34, 26, 18, 10, 2 },
                    { 60, 52, 44, 36, 28, 20, 12, 4 },
                    { 62, 54, 46, 38, 30, 22, 14, 6 },
                    { 64, 56, 48, 40, 32, 24, 16, 8 },
                    { 57, 49, 41, 33, 25, 17, 9, 1 },
                    { 59, 51, 43, 35, 27, 19, 11, 3 },
                    { 61, 53, 45, 37, 29, 21, 13, 5 },
                    { 63, 55, 47, 39, 31, 23, 15, 7 },
            };

            // for (int i = 0; i < temp.length; i++) {
            // for (int j = 0; j < temp[0].length; j++) {
            // int num = random.nextInt((max - min) + 1);
            // System.out.println("Num:- "+num);
            // while (ipset.contains(num)) {
            // System.out.println("Num INSIDE:- " + num);
            // num = random.nextInt((max - min + 1)+min);
            // }

            // ipset.add(num);
            // temp[i][j] = num;

            // }
            // }
            return temp1;

        } else if (permutationType == 4) {
            int min = 1;
            int max = 32;
            // System.out.println("perm4");
            // HashMap<Integer, Integer> hmp = new HashMap<>();
            // int temp[][] = new int[8][6];
            int[][] temp1 = {
                    { 32, 1, 2, 3, 4, 5 },
                    { 4, 5, 6, 7, 8, 9 },
                    { 8, 9, 10, 11, 12, 13 },
                    { 12, 13, 14, 15, 16, 17 },
                    { 16, 17, 18, 19, 20, 21 },
                    { 20, 21, 22, 23, 24, 25 },
                    { 24, 25, 26, 27, 28, 29 },
                    { 28, 29, 30, 31, 32, 1 },
            };

            // for (int i = 0; i < temp.length; i++) {
            // for (int j = 0; j < temp[0].length; j++) {
            // int num = random.nextInt((max - min) + 1);
            // System.out.println("Num:- "+num);
            // while (hmp.get(num)>2) {
            // System.out.println("Num INSIDE:- " + num);
            // num = random.nextInt((max - min + 1)+min);
            // }

            // p2set.add(num);
            // temp[i][j] = num;

            // }
            // }
            return temp1;
        } else {
            int min = 1;
            int max = 32;
            Set<Integer> pset = new HashSet<>();
            // HashMap<Integer, Integer> hmp = new HashMap<>();
            // int temp[][] = new int[8][4];
            int[][] temp1 = {
                    { 16, 7, 20, 21 },
                    { 29, 12, 28, 17 },
                    { 1, 15, 23, 26 },
                    { 5, 18, 31, 10 },
                    { 2, 8, 24, 14 },
                    { 32, 27, 3, 9 },
                    { 19, 13, 30, 6 },
                    { 22, 11, 4, 25 },
            };

            // for (int i = 0; i < temp.length; i++) {
            // for (int j = 0; j < temp[0].length; j++) {
            // int num = random.nextInt((max - min) + 1);
            // System.out.println("Num:- "+num);
            // while (pset.contains(num)) {
            // System.out.println("Num INSIDE:- " + num);
            // num = random.nextInt((max - min + 1)+min);
            // }

            // p2set.add(num);
            // temp[i][j] = num;

            // }
            // }
            return temp1;
        }

    }

    public String[] splitInHalf(String pc1Key) {
        // BigInteger initialPartition[] = new BigInteger[2];
        String initialPartition[] = new String[2];
        // System.out.println("PC1 length:- " + pc1Key.length());
        int n = pc1Key.length() / 2;

        String firstHalfStr = pc1Key.substring(0, n);
        String secondHalfStr = pc1Key.substring(n);

        // System.out.println("FIRST HAKF STR:- " + firstHalfStr + "Length:- " +
        // firstHalfStr.length());
        // System.out.println("SECOND HALF STR:- " + secondHalfStr + "Length:- " +
        // secondHalfStr.length());

        // BigInteger firstHalf = new BigInteger(firstHalfStr);
        // BigInteger secondHalf = new BigInteger(secondHalfStr); // As we know our
        // second half starts from 0 so
        // BigInteger
        // ignore leading zeros that's why we are not getting
        // 0
        // at first

        initialPartition[0] = firstHalfStr;
        initialPartition[1] = secondHalfStr;

        return initialPartition;
    }

    public HashMap<Integer, Integer> getLeftShiftTable() {
        HashMap<Integer, Integer> hmp = new HashMap<>();
        hmp.put(1, 1);
        hmp.put(2, 1);
        hmp.put(3, 2);
        hmp.put(4, 2);
        hmp.put(5, 2);
        hmp.put(6, 2);
        hmp.put(7, 2);
        hmp.put(8, 2);
        hmp.put(9, 1);
        hmp.put(10, 2);
        hmp.put(11, 2);
        hmp.put(12, 2);
        hmp.put(13, 2);
        hmp.put(14, 2);
        hmp.put(15, 2);
        hmp.put(16, 1);

        return hmp;

    }

    public String performXor(String key, String expansionR) {
        String temp = "";
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) == expansionR.charAt(i)) {
                temp += "0";
            } else {
                temp += "1";
            }
        }
        // System.out.println("Temp:- " + temp);
        return temp;
    }

    public String[] splitInEight(String exp_xor_key) {

        String xor_groups[] = new String[8];
        int count = 0;
        for (int i = 0; i < exp_xor_key.length(); i += 6) {
            String group = exp_xor_key.substring(i, i + 6);
            // System.out.println("Group:- " + group);
            xor_groups[count++] = group;
        }
        return xor_groups;
    }

    public int convertBinaryToDecimal(String binary) {
        int decimal = Integer.parseInt(binary, 2);
        return decimal;

    }

    public String convertDecimalToBinary(int decimal) {
        String binary = Integer.toBinaryString(decimal);
        String paddedBinarySBlockNum = String.format("%4s", binary).replace(' ', '0');
        return paddedBinarySBlockNum;
    }

    public String convertBinaryToHexaDecimal(String encryptedBinaryText) {
        StringBuilder hexStringBuilder = new StringBuilder();
        for (int i = 0; i < encryptedBinaryText.length(); i += 4) {
            String binaryGroup = encryptedBinaryText.substring(i, i + 4);
            int decimalValue = Integer.parseInt(binaryGroup, 2);
            hexStringBuilder.append(Integer.toHexString(decimalValue));
        }
        return hexStringBuilder.toString();
    }

    public int[][] getInverseInitialPermutation(int[][] initialPermutation) {

        int inverseIP[][] = {
                { 40, 8, 48, 16, 56, 24, 64, 32 },
                { 39, 7, 47, 15, 55, 23, 63, 31 },
                { 38, 6, 46, 14, 54, 22, 62, 30, },
                { 37, 5, 45, 13, 53, 21, 61, 29 },
                { 36, 4, 44, 12, 52, 20, 60, 28 },
                { 35, 3, 43, 11, 51, 19, 59, 27 },
                { 34, 2, 42, 10, 50, 18, 58, 26 },
                { 33, 1, 41, 9, 49, 17, 57, 25 }
        };
        return inverseIP;
    }

    public String padKey(String key) {
        if (key.length() != 16) {
            while ((key.length() * 4) % 64 != 0) {
                key += '0';
            }
        }
        String hexKey = stringToHex(key);

        return hexKey;
    }

    public String padMessage(String message) {
        String hexaString = stringToHex(message);
        if (hexaString.length() % 64 == 0) {
            return hexaString;
        } else {
            while ((hexaString.length() * 4) % 64 != 0) {
                hexaString += '0';
            }

            return hexaString;
        }
    }

}