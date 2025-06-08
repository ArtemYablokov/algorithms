package com.yablokovs.LC_v3.prefix;

public class NumberOfWaysToSelectBuildings_2222 {
    public static long numberOfWays(String s) { // 001101
        char[] a = s.toCharArray();
        int l = a.length;
        int[] dp = new int[l];

        int ones = 0;
        int zeroes = 0;
        for (int i = 0; i < l; i++) {
            if (a[i] == '1') {
                dp[i] = zeroes;
                ones++;
            } else {
                dp[i] = ones;
                zeroes++;
            }
        }
        // now we got DP where each point tells how many ways of length 2 it have
        // 001101
        // 002223
        long zero2 = 0;
        long one2 = 0;
//        long[] dpL = new long[l];

        long result = 0L;
        for (int i = 0; i < l; i++) {
            if (a[i] == '1') {
//                dpL[i] = zero2;
                result += zero2;
                one2 += dp[i];
            } else {
//                dpL[i] = one2;
                zero2 += dp[i];
                result += one2;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        long l = NumberOfWaysToSelectBuildings_2222.numberOfWays("001101");
        int i = 0;
    }

}
