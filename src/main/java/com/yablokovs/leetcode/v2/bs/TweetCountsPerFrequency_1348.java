package com.yablokovs.leetcode.v2.bs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TweetCountsPerFrequency_1348 {
    Map<String, SortedSet<Integer>> map = new HashMap<>();

    public TweetCountsPerFrequency_1348() {

    }

    public void recordTweet(String tweetName, int time) {
        map.compute(tweetName, (k, v) -> {
           if (v == null) return new TreeSet<>(Set.of(time));
           else {
               v.add(time);
               return v;
           }
        });
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        return null;
    }
}
