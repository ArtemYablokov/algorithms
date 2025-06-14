package com.yablokovs.leetcode.bit;

import java.util.HashSet;
import java.util.Set;

public class MaxXORofTwoNumbers {

    public int findMaximumXOR_MASK(int... nums) {
        int max = 0, mask = 0;

        for (int i = 31; i >= 0; i--) {

            mask = mask | (1 << i); // concat mask with previous

            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask); // add to set any mask if present
            }

            int tmp = max | (1 << i); // concat mask and max

            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }

    public int findMaximumXORExplanation(int[] nums) {
        int maxResult = 0;
        int mask = 0;
        /*The maxResult is a record of the largest XOR we got so far. if it's 11100 at i = 2, it means
        before we reach the last two bits, 11100 is the biggest XOR we have, and we're going to explore
        whether we can get another two '1's and put them into maxResult

        This is a greedy part, since we're looking for the largest XOR, we start
        from the very begining, aka, the 31st postition of bits. */
        for (int i = 31; i >= 0; i--) {
            //The mask will grow like  100..000 , 110..000, 111..000,  then 1111...111
            //for each iteration, we only care about the left parts
            mask = mask | (1 << i);

            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
/*                we only care about the left parts, for example, if i = 2, then we have
                {1100, 1000, 0100, 0000} from {1110, 1011, 0111, 0010}*/
                int leftPartOfNum = num & mask;
                set.add(leftPartOfNum);
            }
            // if i = 1 and before this iteration, the maxResult we have now is 1100,
            // my wish is the maxResult will grow to 1110, so I will try to find a candidate
            // which can give me the greedyTry;
            int greedyTry = maxResult | (1 << i);

            for (int leftPartOfNum : set) {
                //This is the most tricky part, coming from a fact that if a ^ b = c, then a ^ c = b;
                // now we have the 'c', which is greedyTry, and we have the 'a', which is leftPartOfNum
                // If we hope the formula a ^ b = c to be valid, then we need the b,
                // and to get b, we need a ^ c, if a ^ c exisited in our set, then we're good to go
                int anotherNum = leftPartOfNum ^ greedyTry;
                if (set.contains(anotherNum)) {
                    maxResult= greedyTry;
                    break;
                }
            }
            // If unfortunately, we didn't get the greedyTry, we still have our max,
            // So after this iteration, the max will stay at 1100.
        }
        return maxResult;
    }

    class Trie {
        Trie[] children;
        public Trie() {children = new Trie[2];}
    }

    public int findMaximumXORtree(int... nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Trie root = new Trie();
        for (int num : nums) {
            Trie curNode = root;
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >>> i) & 1;
                if (curNode.children[curBit] == null) {
                    curNode.children[curBit] = new Trie();
                }
                curNode = curNode.children[curBit];
            }
        }
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            Trie curNode = root;
            int curSum = 0;

            for (int i = 31; i >= 0; i--) {
                int curBit = (num >>> i) & 1;

                if (curNode.children[curBit ^ 1] != null) {
                    curSum += (1 << i);
                    curNode = curNode.children[curBit ^ 1];
                } else {
                    curNode = curNode.children[curBit];
                }
            }
            max = Math.max(curSum, max);
        }
        return max;
    }
}
