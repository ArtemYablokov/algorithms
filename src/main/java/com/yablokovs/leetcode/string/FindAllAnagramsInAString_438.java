package com.yablokovs.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        short[] init = new short[26];
        for (char c : p.toCharArray()) {
            init[c - 97] = (short) (init[c - 97] + 1);
        }
        boolean[] not = new boolean[26];
        for (int i = 0; i < init.length; i++) {
            if (init[i] == 0)
                not[i] = true;
        }
        char[] array = s.toCharArray();
        int i = 0;
        int j = 0;

        int length = p.length();

        int counter = 0;

        short[] charToNumber = Arrays.copyOf(init, init.length);


        while (j < array.length) { // i < array.length &&

            char start = array[i];
            char end = array[j];
            short numberOfJ = charToNumber[end - 97];

            if (not[end - 97]) { // not in map
                if (counter != 0) {
                    charToNumber = Arrays.copyOf(init, init.length);
                    counter = 0;
                }
                j++;
                i = j;
            } else {
                if (numberOfJ > 0) { // move right pointer
                    System.out.println(charToNumber[end - 97]);
                    charToNumber[end - 97] -= 1;
                    counter++;
                    if (counter == length)
                        result.add(i);
                    j++;

                } else { //  (numberOfJ == 0) char from map, but run out --> need to move i till found it
                    while (start != end) {
                        charToNumber[start - 97] += 1;
                        i++;
                        start = array[i];
                        counter--;
                    }
                    if (counter == length)
                        result.add(i + 1);
                    i++;
                    j++;
                }
            }
        }
        return result;
    }

}
