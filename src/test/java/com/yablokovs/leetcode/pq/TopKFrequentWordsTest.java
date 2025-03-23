package com.yablokovs.leetcode.pq;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentWordsTest {

    @Test
    void topKFrequent() {
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        String[] arr = {"i","love","leetcode","i","love","coding"};

        List<String> list = topKFrequentWords.topKFrequent(arr, 2);
    }
}