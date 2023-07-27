package com.yablokovs.leetcode.array.backtracking;

import com.yablokovs.leetcode.array.dp.WordBreak_139;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class WordBreak139Test {

    @Test
    @SneakyThrows
    void wordBreak() {

//        Date parse = new SimpleDateFormat("HH:mm").parse("15:15");

        boolean abc = "abcdef".startsWith("abc");
        boolean def = "abcdef".startsWith("deff", 3);


        WordBreak_139 wordBreak139 = new WordBreak_139();
        wordBreak139.wordBreakLetterApproach("acabaad", Set.of("ab", "ac", "aad"));



        System.out.println(wordBreak139.wordBreak("a", List.of("ab", "ac", "aad"))); // false
        System.out.println(wordBreak139.wordBreak("ac", List.of("ab", "ac", "aad")));
        System.out.println(wordBreak139.wordBreak("acz", List.of("ab", "ac", "aad"))); // false
        System.out.println(wordBreak139.wordBreak("zac", List.of("ab", "ac", "aad"))); // false
        System.out.println(wordBreak139.wordBreak("acabaad", List.of("ab", "ac", "aad")));
        System.out.println(wordBreak139.wordBreak("acabaada", List.of("ab", "ac", "aad"))); // false

        String ss = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";

        long l = System.currentTimeMillis();
        System.out.println(wordBreak139.wordBreak(ss, List.of("a", "aa"/*, "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"*/))); // false

        long l2 = System.currentTimeMillis();
        System.out.println((l2 - l));

    }
}