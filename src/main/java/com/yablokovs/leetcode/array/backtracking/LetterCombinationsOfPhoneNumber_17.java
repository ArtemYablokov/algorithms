package com.yablokovs.leetcode.array.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber_17 {
    public List<String> letterCombinations(String digits) {

        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));

        List<String> result = new ArrayList<>();
        comb(digits.toCharArray(), 0, new StringBuilder(), map, result);

        return result;
    }

    private void comb(char[] digits, int index, StringBuilder current, Map<Character, List<Character>> map, List<String> result) {
        if (index == digits.length) {
            result.add(current.toString());
            return;
        }
        List<Character> letters = map.get(digits[index]);

        for (Character c : letters) {
            StringBuilder temp = new StringBuilder(current);
            temp.append(c);

            comb(digits, index + 1, temp, map, result);

        }
    }
}
