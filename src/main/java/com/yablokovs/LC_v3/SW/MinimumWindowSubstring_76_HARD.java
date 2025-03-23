package com.yablokovs.LC_v3.SW;

public class MinimumWindowSubstring_76_HARD {

    public static final int BOTTOM = Math.min('a', 'A');
    public static final int SIZE = Math.max('z', 'Z') - Math.min('a', 'A') + 1;

    public String minWindow(String s, String t) {
        int[] arr = new int[SIZE];
        int i = 0;
        int j = 0;
        char[] a = s.toCharArray();
        int l = a.length;
        int min = l + 1;
        int ix = 0;
        int jx = 0;

        int count = t.length();
        for (char c : t.toCharArray()) arr[c - BOTTOM]++;
        boolean[] valid = new boolean[SIZE];

        for (int k = 0; k < SIZE; k++) {
            if (arr[k] > 0) valid[k] = true;
        }


        while (j < l) {
            char c = a[j];
            arr[c - BOTTOM]--;
            if (valid[c - BOTTOM] && arr[c - BOTTOM] >= 0) { // it can be excessive letter
                count--; // don't let count fall down 0
            }

            while (count == 0) {
                System.out.println("i = " + i);
                System.out.println("j = " + j);
                if (min >= j - i + 1) {
                    ix = i;
                    jx = j;
                    min = j - i + 1;
                }

                arr[a[i] - BOTTOM]++;
                if (valid[a[i] - BOTTOM] && arr[a[i] - BOTTOM] > 0) { // only when char is in word
                    count++;
                }

                i++;
            }

            j++;
        }

        return min == l + 1 ? "" : s.substring(ix, jx + 1); // j - excluded
    }
}
