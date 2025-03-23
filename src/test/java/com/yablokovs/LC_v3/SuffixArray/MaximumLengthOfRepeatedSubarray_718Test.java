package com.yablokovs.LC_v3.SuffixArray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.yablokovs.LC_v3.util.Util.build;

class MaximumLengthOfRepeatedSubarray_718Test {

    @Test
    void findLength() {

        MaximumLengthOfRepeatedSubarray_718 solution = new MaximumLengthOfRepeatedSubarray_718();
        int max = solution.max("abc", "ab");
        int max2 = solution.max("abc", "");

        String[] build = solution.build(new int[]{78, 79, 77});// == N O M
//        int[] build1 = build(1, 2, 3);

        int length = solution.findLength(build(1, 2, 3, 2, 1), build(3, 2, 1, 4, 7));

        int length2 = solution.findLength_Trie(build(0, 0, 0, 0, 0), build(0, 0, 0, 0, 0));

        int lengthTrie = solution.findLength_Trie(build(1, 2, 3, 2, 1), build(3, 2, 1, 4, 7));

    }


}