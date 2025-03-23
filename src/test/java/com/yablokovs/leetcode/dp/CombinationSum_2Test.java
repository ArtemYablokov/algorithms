package com.yablokovs.leetcode.dp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSum_2Test {

    @Test
    void test1() {
        CombinationSum_2 combinationSum2 = new CombinationSum_2();
        combinationSum2.test();
    }


    public void parseLeetCode(String s) {
        List<String> result = new ArrayList<>();

        s = s.replaceAll(" ", "");
        s = s.replaceAll("\n", "");

        Pattern p = Pattern.compile("/problems/(.*?)\\)");
        Matcher matcher = p.matcher(s);
        while (matcher.find()) {
            String group = matcher.group(1);
//            result.add("https://leetcode.com/problems/" + group);
            System.out.println("https://leetcode.com/problems/" + group);
        }

        int n = 0;


    }

    @Test
    public void testtest(){
        parseLeetCode("# Title\n" +
                "1 Two Sum (/problems/two-sum)\n" +
                "2 Add Two Numbers (/problems/add-two-numbers)\n" +
                "146 LRU Cache (/problems/lru- cache)\n" +
                "42 Trapping Rain Water (/problems/trapping-rain-\n" +
                "water)\n" +
                "5 Longest Palindromic Substring (/problems/longest-palindromic- substring)\n" +
                "4 Median of Two Sorted Arrays (/problems/median-of-two-\n" +
                "sorted-arrays)\n" +
                "200 Number of Islands (/problems/number-of-islands)\n" +
                "15 3Sum (/problems/3sum)\n" +
                "53 Maximum Subarray (/problems/maximum-\n" +
                "subarray)\n" +
                "3 Longest Substring Without Repeating Characters\n" +
                "(/problems/longest-substring- without-repeating-characters)\n" +
                "21 Merge Two Sorted Lists (/problems/merge-two-sorted-\n" +
                "lists)\n" +
                "20 Valid Parentheses (/problems/valid-parentheses)\n" +
                "Solution\n" +
                "\uF0F6\n" +
                "Difficulty \uF0D7 Status \uF0D7 Lists \uF0D7 Tags \uF0D7 Acceptance Difficulty Frequency \uE085\n" +
                "44.8% Easy 32.3% Medium\n" +
                "28.6% Medium 45.8% Hard\n" +
                "28.3% Medium\n" +
                "27.8% Hard\n" +
                "43.8% Medium 25.3% Medium\n" +
                "45.1% Easy\n" +
                "29.2% Medium\n" +
                "50.1% Easy\n" +
                "37.6% Easy\n" +
                "\uF15C (/articles/two-sum) \uF15C (/articles/add-two-\n" +
                "numbers)\n" +
                "\uF15C (/articles/lru-cache)\n" +
                "\uF15C (/articles/trapping- rain-water)\n" +
                "\uF15C (/articles/longest- palindromic-substring)\n" +
                "\uF15C (/articles/median-of- two-sorted-arrays)\n" +
                "\uF15C (/articles/number-of- islands)\n" +
                "\uF15C (/articles/maximum- subarray)\n" +
                "\uF15C (/articles/longest- substring-without- repeating-characters)\n" +
                "\uF15C (/articles/merged- two-sorted-lists)\n" +
                "\uF15C (/articles/valid- parentheses)" +
                "");
    }
}