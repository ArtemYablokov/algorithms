package com.yablokovs.leetcode.v2.graph;

import java.util.HashSet;
import java.util.Set;

public class FindCelebrity_277 {

    /* The knows API is defined in the parent class Relation.*/

    int[][] mx = new int[][] {
            {1,0,1},{1,1,0},{0,1,1}
    };
    boolean knows(int a, int b) {
        return mx[a][b] == 1;
    }


    // first pass - find person who don't know anyone // n^2
    // second - for each of them check that all others know him


    Set<Integer> notCelebrity = new HashSet<>();
    int l;

    public int findCelebrity(int n) {
        l = n;
        // first pass - find person who don't know anyone // n^2
        // second - for each of them check that all others know him

        for (int i = 0; i < n; i++) {
            boolean b = check(i);
            if (b)
                return i;
        }
        return -1;
    }

    // TODO: 4/11/24 it could be dfs ???
    private boolean check(int source) {
        if (notCelebrity.contains(source))
            return false;

        for (int target = 0; target < l; target++) {
            if (target == source /*|| notCelebrity.contains(target)*/)
                continue;

            if (knows(source, target)) { // add to mx
                notCelebrity.add(source);
                return false; // ????
            }
            if (!knows(target, source)) { // add to mx
                notCelebrity.add(source);
                return false; // ????
            }
        }
        return true;
    }


}
