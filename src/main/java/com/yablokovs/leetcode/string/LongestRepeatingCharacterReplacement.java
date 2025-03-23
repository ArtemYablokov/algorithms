package com.yablokovs.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// JSDSSMESSR
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        Map<Character, List<int[]>> map = new HashMap<>();


        char[] chars = s.toCharArray();
        int l = chars.length;
        int i = 0;

        while( i < l ) {
            char cur = chars[i];
            int j = i;

            while (j + 1 < l && chars[j + 1] == cur) j++;
            int[] temp = {i, j};

            map.compute( cur, (key, val) -> {
                if (val == null) return new ArrayList<>(List.of(temp));
                else {
                    val.add(temp);
                    return val;
                }
            });
            i = j + 1;
        }
        // map.get('S').forEach(a -> System.out.println( Arrays.toString(a) ));
        // System.out.println(Collections.toString( map.get('C') ));

        int max = 0;
        for ( Map.Entry<Character, List<int[]>> e : map.entrySet() ) {
            List<int[]> list = e.getValue();
            int size = list.size();

            char ch = e.getKey();

            int idx = 0;
            while ( idx < size ) {
                // if (ch == 'S') System.out.println("SSSS");
                int replaces = k;

                int[] arr = list.get(idx);
                int start = arr[0];
                int end = arr[1];

                int counter = 0;
                while (idx + 1 < size && replaces > 0) {
                    counter++;
                    idx++;
                    int[] next = list.get(idx);

                    int dist = next[0] - end - 1;
                    if ( dist > replaces ) break;

                    replaces -= dist;
                    end = next[1];
                }
                if (counter == 0) idx++;
                else idx--;

                int spaces = (start - 0) + (l - 1 - end) ;

                int curL = end - start + 1 + Math.min(spaces, replaces); // if (replaces > 0)

                max = Math.max(max, curL);

            }
        }

        return max;
    }
}
