package com.yablokovs.leetcode.sliding_window;

public class FruitIntoBasket {
    public int totalFruit(int[] fruits) {
        // if (fruits.length < 2) return fruits.length;
        Integer first = -1;
        int second = fruits[0];
        int start = 0;

        int firstCounter = 0;
        int secondCounter = 1;
        int max = 1;

        for (int i = 1; i < fruits.length; i++) {
            int cur = fruits[i];
            if (cur == second || cur == first) {
                if (cur == first) firstCounter++;
                else secondCounter++;

                max = Math.max(max, i - start + 1);

                continue;
            }
            if (first == -1) {
                first = second;
                firstCounter = secondCounter;
                secondCounter = 1;
                second = cur;
                max = Math.max(max, i - start + 1);

                continue;
            }
            while (firstCounter > 0) {
                if (fruits[start++] == first) firstCounter--;
            }
            System.out.println(start);
            first = second;
            second = cur;
            firstCounter = secondCounter;
            secondCounter = 1;

        }

        return max;
    }
}
