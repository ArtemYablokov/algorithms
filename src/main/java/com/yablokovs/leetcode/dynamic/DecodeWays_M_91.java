package com.yablokovs.leetcode.dynamic;

public class DecodeWays_M_91 {


    public int numDecodings(String s) {

        int[] chars = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i) - 48;
        }

        int length = chars.length;
        if (chars[0] == 0)
            return 0;
        if (length == 1) {
            return 1;
        }

        int[] response = new int[length + 1];

        response[0] = 1;
        response[1] = 1;

        int previous = chars[0];

        for (int i = 1; i < length; i++) {
            int current = chars[i];

            if (current == 0) {
                if (previous == 1 || previous == 2) {
                    response[i + 1] = response[i - 1]; // 20
                } else {
                    return 0; // 90
                }
            } else if (previous == 1 || (previous == 2 && current < 7)) {
                response[i + 1] = response[i] + response[i - 1];
            } else {
                response[i + 1] = response[i];
            }

            previous = current;
        }

        return response[length];
    }
}
