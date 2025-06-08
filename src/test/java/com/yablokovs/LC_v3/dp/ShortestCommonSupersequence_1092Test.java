package com.yablokovs.LC_v3.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortestCommonSupersequence_1092Test {

    @Test
    void shortestCommonSupersequence() {
        ShortestCommonSupersequence_1092 sol = new ShortestCommonSupersequence_1092();

//        String s1 = sol.shortestCommonSupersequence("baaabbbbba", "babbaaba"); // babbaabbbbba
//        String s = sol.shortestCommonSupersequence("ac", "ba");
//        String s2 = sol.shortestCommonSupersequence("aca", "aa");
//        String s3 = sol.shortestCommonSupersequence("abac", "bacd");
//        String s4 = sol.shortestCommonSupersequence("abac", "cad");
//        String s5 = sol.shortestCommonSupersequence("aaa", "aaa");
//        String s6 = sol.shortestCommonSupersequence("aaa", "aaaz");


        ShortestCommonSupersequence_1092_V2 v2 = new ShortestCommonSupersequence_1092_V2();
        String v = v2.shortestCommonSupersequence("baaabbbbba", "babbaaba"); // babbaabbbbba

    }
}

