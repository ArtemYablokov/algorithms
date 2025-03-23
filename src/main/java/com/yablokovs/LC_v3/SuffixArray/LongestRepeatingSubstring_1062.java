package com.yablokovs.LC_v3.SuffixArray;

import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;

public class LongestRepeatingSubstring_1062 {
    public int longestRepeatingSubstring(String s) {
        int l = s.length();
        int[][] ch = new int[l + 1][2];
        ch[l] = new int[]{'$', l};
        for (int i = 0; i < l; i++) {
            ch[i] = new int[]{s.charAt(i), i};
        }
        Arrays.sort(ch, Comparator.comparingInt(a -> a[0])); // compare by char

        int[] coe = new int[l + 1];
        coe[0] = 0;
        for (int i = 1; i < l + 1; i++) {
            if (ch[i - 1][0] == ch[i][0])
                coe[i] = coe[i - 1];
            else
                coe[i] = coe[i - 1] + 1;
        }
        int[] coe2 = new int[l + 1];
        for (int i = 0; i < l + 1; i++) {
            coe2[ch[i][1]] = coe[i];
        }
        // INITIAL STATE

        int countK = countK(s.length());

        Pair[] pairs = null;
        for (int k = 0; k < countK; k++) {
            // array of Pairs if Class of Equivalence -> ix
            pairs = new Pair[l + 1]; // +1 is for $ sign as smallest one
            for (int i = 0; i < l + 1; i++) {
                int step = 1 << k;
                pairs[i] = new Pair(i, coe2[i], coe2[(i + step) % (l + 1)]);
            }
            Arrays.sort(pairs,
                    (p1, p2) -> p1.left == p2.left ?
                            Integer.compare(p1.right, p2.right) :
                            Integer.compare(p1.left, p2.left));

            // populate COE one by one
            coe[pairs[0].ix] = 0;
            for (int i = 1; i < l + 1; i++) {
                Pair pair = pairs[i];
                if (pair.left == pairs[i - 1].left && pair.right == pairs[i - 1].right)
                    coe[i] = coe[i - 1];
                else
                    coe[i] = coe[i - 1] + 1;
            }
            // assign to index COE
            for (int i = 0; i < l + 1; i++) {
                coe2[pairs[i].ix] = coe[i];
            }
            int cv = 0;
        }
        int max = 0;
        for (int i = 1; i < l + 1; i++) {
            int prev = pairs[i - 1].ix;
            int cur = pairs[i].ix;
//            System.out.println(s.substring(prev));
//            System.out.println(s.substring(cur));
//            System.out.println();
            int count = 0;
            while (prev < l && cur < l && s.charAt(prev++) == s.charAt(cur++)) {
                count++;
            }
            if (count > max)
                max = count;
        }

        return max;
    }

    public int countK(int l) {
        int result = 0;
        while (1 << result < l) {
            result += 1;
        }
        return result - 1;
    }

//    @ToString
    class Pair {
        int ix;
        int left;
        int right;

        public Pair(int ix, int left, int right) {
            this.ix = ix;
            this.left = left;
            this.right = right;
        }
    }
}
