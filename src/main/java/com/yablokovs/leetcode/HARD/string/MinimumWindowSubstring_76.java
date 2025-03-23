package com.yablokovs.leetcode.HARD.string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_76 {
    public String minWindow(String s, String t) {

        String response = "";

        char[] target = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : target) {
            map.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        int targetLenghtConst = target.length;

        int wordCounter = 0;
        char[] source = s.toCharArray();

        int i = 0;
        while (i < source.length && map.get(source[i]) == null)
            i++;
        int j = i;

        while (j < source.length) {

            // EXPAND TO RIGHT
            while (j < source.length) {
                char end = source[j];
                Integer endNum = map.get(end);
                if (endNum == null) {
                    j++;
                    continue;
                }
                if (endNum > 0)
                    wordCounter++;

                map.put(end, endNum - 1);

                if (wordCounter == targetLenghtConst) { // all chars were encountered -> found whole word
                    break; // j stayed on last char
                }
                j++;
            }
            if (j == source.length)
                break; // не нашли полное слово

            // TRY TO REDUCE LEFT - убрать дубликаты
            while (i <= j) {
                char start = source[i];
                Integer startNum = map.get(start);
                if (startNum == null) {
                    i++;
                    continue;
                }
                if (wordCounter == targetLenghtConst - 1) { // эта буква в слове. До этого уже убрали буква одну из слова. Значит надо расширять вправо
                    j++;
                    break;
                }

                if (startNum < 0) {  // DUPLICATE
                    map.put(start, startNum + 1);
                    i++;
                    continue;
                }
                if (startNum == 0) { // ровно одна буква.
                    if (response.equals("") || j - i + 1 < response.length())
                        response = s.substring(i, j + 1);
                    if (response.length() == targetLenghtConst)
                        return response;
                    wordCounter--;

                    map.put(start, startNum + 1);
                    i++;
                }
            }
        }
        return response;
    }
}
