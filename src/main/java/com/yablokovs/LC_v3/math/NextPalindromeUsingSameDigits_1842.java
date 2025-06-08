package com.yablokovs.LC_v3.math;

public class NextPalindromeUsingSameDigits_1842 {
    public String nextPalindrome(String num) {
        int l = num.length();
        int h = l/2;
        String left = num.substring(0, h); // exclusive
        char[] c = left.toCharArray();

        int i = h - 1;
        while (i > 0 && c[i] <= c[i - 1]){
            i--;
        }
        if (i == 0) return num;


        int j = h - 1;
        while (j > i - 1 && c[j] <= c[i - 1]) j--;
        swap(j, i - 1, c);

        for (int ix = 0; ix < (h - i) / 2; ix++) {
            swap(i + ix, h - 1 - ix, c);
        }
        StringBuilder sb = new StringBuilder();
        for (int ix = 0; ix < h; ix++) {
            sb.append(c[ix]);
        }
        if (l % 2 != 0) sb.append(num.charAt(l / 2));
        for (int ix = h - 1; ix >= 0; ix--) {
            sb.append(c[ix]);
        }

        return sb.toString();
    }

    void swap(int i, int j, char[] c) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
}
