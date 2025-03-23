package com.yablokovs.leetcode.HARD.array;

public class TrappingRainWater_42 {


    public int trap(int[] height) {
        int i = 0;
        int j = height.length - 1;

        int start = height[i];
        int end = height[j];

        // skip
        while (i < j && start == 0 ) {
            i++;
            start = height[i];
        }
        while (j > i && end == 0 ) {
            j--;
            end = height[j];
        }

        int minPointer = Math.min(end, start);

        int currentBottom = 0;

        int result = 0;
        while (i < j) {

            for (int index = i + 1; index < j; index++) {
                int current = height[index];
                if(current < minPointer ) result += (minPointer - Math.max(currentBottom, current)); // && currentBottom < current
            }
            currentBottom = minPointer;

            if (start == minPointer) {
                while (i < j && start <= minPointer ) {
                    i++;
                    start = height[i];
                }
            }
            if (end == minPointer) {
                while (i < j && end <= minPointer ) {
                    j--;
                    end = height[j];
                }
            }

            minPointer = Math.min(end, start);

        }

        return result;
    }
}
