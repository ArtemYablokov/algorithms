package com.yablokovs.leetcode.v2.string;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits_1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        String lowS = String.valueOf(low);
        String highS = String.valueOf(high);
        int minLength = lowS.length();
        int maxLength = highS.length();

        List<Integer> result = new ArrayList<>();

        for (int i = minLength; i <= maxLength; i++) { // LENGHT = 3
            int first = 1;
            // int add = 0;
            while (first + minLength - 1 < 10) {
                int current = 0;
                for (int k = 0; k < minLength; k++) { // < 3
                    current *= 10;
                    current += (first + k);
                }
                if (current > high)
                    break;
                result.add(current);
                first++;
            }
        }

        return result;
    }

}
