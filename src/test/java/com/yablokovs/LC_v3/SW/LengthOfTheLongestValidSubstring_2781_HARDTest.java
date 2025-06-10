package com.yablokovs.LC_v3.SW;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

class LengthOfTheLongestValidSubstring_2781_HARDTest {

    @Test
    void test() {
        LengthOfTheLongestValidSubstring_2781_HARD solu = new LengthOfTheLongestValidSubstring_2781_HARD();

        int res = solu.longestValidSubstring("cbaaaabc",
                Stream.of("aaa", "cb")
                        .collect(Collectors.toList())

        );

    }
}