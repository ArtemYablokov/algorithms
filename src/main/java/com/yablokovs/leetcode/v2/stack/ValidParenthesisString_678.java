package com.yablokovs.leetcode.v2.stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ValidParenthesisString_678 {
    String open = "(";

    public boolean checkValidString(String s) {
        char[] a = s.toCharArray();

        LinkedList<String> stack = new LinkedList<>();
        int counter = 0;
        for (char c : a) {
            if (c == '(') {
                if (counter > 0)
                    stack.push(String.valueOf(counter));
                counter = 0;
                stack.push(open);
            }
            if (c == '*') {
                counter++;
            }
            if (c == ')') {
                if (stack.isEmpty() && counter == 0)
                    return false;
                boolean foundOpen = false;
                while (!stack.isEmpty()) {
                    String last = stack.pop();

                    if (!last.equals(open)) {
                        Integer temp = Integer.parseInt(last);
                        counter += temp;
                    } else {
                        foundOpen = true;
                        break;
                    }
                }
                if (!foundOpen)
                    counter--;
            }
        }

        int balance = 0;
        while (!stack.isEmpty()) {
            String cur = stack.pop();
            if (cur.equals(open)) {
                if (balance == 0)
                    return false;
                balance--;
            } else
                balance += Integer.parseInt(cur);
        }

        return true;

    }

    public String largestNumber(int[] nums) {
        List<String> list = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> compare(b, a))
                .toList();

        String joined = String.join("", list);

        return "";
    }
    // 57 56 55 54 53 525 52


    // 1234.12341
    // 12341.1234

//    12341
//    12341 1234

    // 432
    // 43243
    private int compare(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
//        int step = 0;
        int step =  l1 + l2;
//        if (l1 > l2) {
//            int r = l1 % l2;
//            if (r == 0)
//                step = l1;
//            else
//                step = (l1 + (l2 - r));
//        } else {
//            int r = l2 % l1;
//            if (r == 0)
//                step = l2;
//            else
//                step = (l2 + (l1 - r));
//        }
        for (int i = 0; i < step; i++) {
            char c1 = s1.charAt(i % l1);
            char c2 = s2.charAt(i % l2);
            if (c1 > c2)
                return 1;
            if (c2 > c1)
                return -1;
        }
        return 0;
    }

}
