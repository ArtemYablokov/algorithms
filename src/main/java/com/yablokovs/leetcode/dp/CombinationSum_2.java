package com.yablokovs.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CombinationSum_2 {
    public void test() {
        Set<List<Integer>> list = new HashSet<>(Set.of(List.of(1, 2), List.of(2, 1)));
        List<List<Integer>> lists = list.stream().map(v -> v.stream().sorted().toList()).toList();

        int[] ints = new int[1];

//        Integer[] ar = Arrays.stream(ints).mapToObj(Integer::new).toArray();

        boolean[] used = new boolean[ints.length];

//        Arrays.sort(ints, Collections.reverseOrder() );

        int n = 0;
    }


}
