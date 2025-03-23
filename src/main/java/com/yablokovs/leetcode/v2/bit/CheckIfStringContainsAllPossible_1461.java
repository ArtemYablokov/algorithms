package com.yablokovs.leetcode.v2.bit;

import java.util.HashSet;
import java.util.Set;

public class CheckIfStringContainsAllPossible_1461 {
    public boolean hasAllCodes(String s, int k) {
        long max = getMax(k);
        System.out.println(getMax(k));
        char[] chars = s.toCharArray();
        int l = chars.length;
        if (l < k)
            return false;
        long cur = 0L;
        for (int i = 0; i < k; i++) {
            cur *= 2;
            cur &= (chars[i] - '0');
        }
        System.out.println(cur);
        Set<Long> set = new HashSet<>();
        set.add(cur);
        long numWoutLeftBit = getMax(k - 1);
        for (int i = k; i < l; i++) {
            long left = cur & (1 << (k - 1));
            if (left > 0) {
                cur = cur & numWoutLeftBit;
            }
            System.out.println(cur);
            cur *= 2;
            cur += (chars[i] - '0');
            set.add(cur);
        }
        for (long i = 0; i <= max; i++) {
            if (!set.contains(i))
                return false;
        }

        return true;
    }

    private long getMax(int k) {
        long result = 0;
        for (int i = 0; i < k; i++) {
            result *= 2;
            result += 1;
        }
        return result;
    }

}
