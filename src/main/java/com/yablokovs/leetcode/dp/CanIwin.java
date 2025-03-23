package com.yablokovs.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class CanIwin {
//    Map<String, Boolean> map = new HashMap<>();
//    char[] used;

    Map<Integer, Boolean> map = new HashMap<>();
    int limit;
    int target;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        target = desiredTotal;
        limit = maxChoosableInteger;

        if ((limit + 1) * limit / 2 < target) return false;

        return rec(0, target);
    }
// 1     // 2
    private boolean rec(int state, int left) {
        if (left <= 0) return false; // prev player reach the target

        if (map.containsKey(state)) return map.get(state);

        for (int i = 1; i <= limit; i++) {
            if (checkState(state, i) > 0) continue;
            state = modifyState(true, state, i);

            boolean nextWin = rec(state, left - i);
            if (!nextWin) {
                map.put(state, true);
                return true;
            }
            state = modifyState(false, state, i); // return back state
        }
        map.put(state, false);
        return false;
    }

    private int modifyState(boolean add, int state, int position) {
        int ix = 1 << position - 1;
        if (add) state |= ix;
        else state ^= ix;
        return state;
    }

    public int checkState(int state, int position) {
        int ix = 1 << position - 1;
        return state & ix;
    }

    class Solution {
        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            if (desiredTotal <= 0) return true;
            if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;

            Boolean[] memo = new Boolean[1 << maxChoosableInteger];
            return canWin(maxChoosableInteger, desiredTotal, 0, memo);
        }

        private boolean canWin(int max, int total, int state, Boolean[] memo) {
            if (total <= 0) return false;
            if (memo[state] != null) return memo[state];

            for (int i = 1; i <= max; i++) {
                int bit = 1 << (i - 1);
                if ((state & bit) == 0) {
                    if (!canWin(max, total - i, state | bit, memo)) {
                        memo[state] = true;
                        return true;
                    }
                }
            }

            memo[state] = false;
            return false;
        }
    }

//    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
//        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
//        if (sum < desiredTotal)
//            return false;
//        if (desiredTotal <= 0)
//            return true;
//
//        used = new char[maxChoosableInteger + 1];
//        Arrays.fill(used, '0');
//        return helper(desiredTotal);
//    }

//    public boolean helper(int desiredTotal) {
//        if (desiredTotal <= 0)
//            return false;
//        String key = format(used);
//        if (!map.containsKey(key)) {
//            // try every unchosen number as next step
//            for (int i = 1; i < used.length; i++) {
//                if (used[i] == '0') {
//                    used[i] = '1';
//                    // check whether this lead to a win (i.e. the other player lose)
//                    if (!helper(desiredTotal - i)) {
//                        map.put(key, true);
//                        used[i] = '0';
//                        return true;
//                    }
//                    used[i] = '0';
//                }
//            }
//            map.put(key, false);
//        }
//        return map.get(key);
//    }

    // transfer boolean[] to an Integer
    public String format(char[] used) {
        return new String(used);
    }
}
