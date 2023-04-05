package com.yablokovs.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {

    public static void main(String[] args) {
        String test = "([]{)}";
//        System.out.println(test.charAt(0) - 0);
//        System.out.println(test.charAt(1) - 0);

        boolean valid = isValid(test);
        int n = 0;
    }

    public static boolean isValid(String s) {

        Map<Character, Character> openToClose = new HashMap<>();
        openToClose.put('(', ')');
        openToClose.put('[', ']');
        openToClose.put('{', '}');

        char[] stack = new char[s.length() + 1]; // +1 так как  pointer++ вылезет за пределы массива
        int pointer = 0;

        char[] chars = s.toCharArray();

        for (char aChar : chars) {
            char topOfStack = stack[pointer];
            if (openToClose.get(topOfStack) != null && openToClose.get(topOfStack) == aChar) {
                pointer--;
            } else {
                pointer++;
                stack[pointer] = aChar;
            }
        }

        return pointer == 0;
    }
}
