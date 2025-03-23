package com.yablokovs.leetcode.v2.string;

public class LongestSubstringWithEvenVowels_1371 {
    public int findTheLongestSubstring(String s) {
        int aF = -1;
        int eF = -1;
        int iF = -1;
        int oF = -1;
        int uF = -1;
        char[] ch = s.toCharArray();
        int l = ch.length;
        for (int ix = l - 1; ix >= 0; ix--) {
            char cur = ch[ix];
            if (cur == 'a')
                aF = ix;
            else if (cur == 'e')
                eF = ix;
            else if (cur == 'i')
                iF = ix;
            else if (cur == 'o')
                oF = ix;
            else if (cur == 'u')
                uF = ix;
        }
        int a = 0;
        int e = 0;
        int i = 0;
        int o = 0;
        int u = 0;

        int max = 0;
        for (int ix = 0; ix < l; ix++) {
            char cur = ch[ix];
            if (cur == 'a')
                a++;
            else if (cur == 'e')
                e++;
            else if (cur == 'i')
                i++;
            else if (cur == 'o')
                o++;
            else if (cur == 'u')
                u++;

            int leftMost = -1;

            if (a % 2 != 0)
                leftMost = Math.max(leftMost, aF);
            if (e % 2 != 0)
                leftMost = Math.max(leftMost, eF);
            if (i % 2 != 0)
                leftMost = Math.max(leftMost, iF);
            if (o % 2 != 0)
                leftMost = Math.max(leftMost, oF);
            if (u % 2 != 0)
                leftMost = Math.max(leftMost, uF);

            max = Math.max(max, ix - leftMost);
        }

        return max;
    }

}
