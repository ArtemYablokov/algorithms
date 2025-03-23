package com.yablokovs.leetcode.HARD.string;

import org.junit.jupiter.api.Test;

class ClosestPalindromicStringTest {

    @Test
    void nearestPalindromic() {

        ClosestPalindromicString closestPalindromicString = new ClosestPalindromicString();

//        String re = closestPalindromicString.nearestPalindromic(String.valueOf("902"));

//        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            double random = Math.random();
            int val = (int) (random * 1000000000);
//            list.add(String.valueOf(val));
            String s = closestPalindromicString.nearestPalindromic(String.valueOf(val));

            if (Math.abs(Integer.parseInt(s) - val)  > 10) {
                System.out.println(val);
                System.out.println(s);
                System.out.println();
            }

        }
//        for (int i = 0; i < 10; i++) {
//            double random = Math.random();
//            int val = (int) (random * 1000);
////            list.add(String.valueOf(val));
//            String s = closestPalindromicString.nearestPalindromic(String.valueOf(val));
//            System.out.println(val);
//            System.out.println(s);
//            System.out.println();
//        }

        String fasd = closestPalindromicString.nearestPalindromic("3919925");


    }
}