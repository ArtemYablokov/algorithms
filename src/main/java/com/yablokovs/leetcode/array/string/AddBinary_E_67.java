package com.yablokovs.leetcode.array.string;

public class AddBinary_E_67 {

    public static void main(String[] args) {

        addBinary("1010", "1011");
    }

    // TODO: 4/17/23 charAt - iterate from front.
    public static String addBinaryString(String a, String b) {
        String longer = b;
        String shorter = a;
        if (a.length() > b.length()) {
            longer = a;
            shorter = b;
        }

        int result = 0;
        int holder = 0;

        int i;
        for (i = 0; i < shorter.length(); i++) {
            int s = shorter.charAt(i) - 48;
            int l = longer.charAt(i) - 48;

            int bit = holder ^ s ^ l;
            result += bit * (10 ^ i);

            holder = (holder + s + l) > 1 ? 1 : 0;
        }

        for (i++; i < longer.length(); i++) {
            int l = longer.charAt(i) - 48;

            int bit = holder ^ l;
            result += bit * (10 ^ i);

            holder = (holder & l) == 1 ? 1 : 0;
        }


        return String.valueOf(result);
    }

    public static String addBinary(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();

        int i;
        int holder = 0;
        StringBuilder sb = new StringBuilder();

        for (i = 0; i < charsA.length && i < charsB.length; i++) {
            int aint = charsA[charsA.length - 1 - i] - 48;
            int bint = charsB[charsB.length - 1 - i] - 48;

            int bit = aint ^ bint ^ holder;
            sb.append(bit);

            holder = holder + aint + bint > 1 ? 1 : 0;

            int n = 0;
        }

        if (charsB.length > charsA.length) charsA = charsB;

        for (i = i; i < charsA.length; i++) {

            int aint = charsA[charsA.length - 1 - i] - 48;

            int bit = aint ^ holder;
            sb.append(bit);

            holder = holder + aint > 1 ? 1 : 0;
        }

        if (holder > 0) {
            sb.append(holder);
        }
        System.out.println();

        return String.valueOf(sb.reverse());
    }

    private static int power10(int i) {
        int result = 1;
        for (int j = 0; j < i; j++) {
            result *= 10;
        }
        return result;
    }
}
