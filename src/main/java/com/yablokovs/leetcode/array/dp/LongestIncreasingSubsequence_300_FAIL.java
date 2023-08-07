package com.yablokovs.leetcode.array.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence_300_FAIL {

    public int lengthOfLIS_FAIl(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        int[] indexes = new int[length];

        dp[length - 1] = 1; // END
        indexes[length - 1] = -1; // reeference that end of ARRAY
        int currentMax = 1;

        for (int i = length - 2; i > -1; i--) {
            int current = nums[i];
            int nextIndex = i + 1;

            int next = nums[nextIndex];
            if (current < next) {
                if (dp[nextIndex] == currentMax) {
                    dp[i] = dp[nextIndex] + 1;
                    currentMax = Math.max(dp[i], currentMax);
                    indexes[i] = nextIndex;
                } else {
                    // TODO: 7/30/23 find MAX from right array
                }

            } else {
                while (nextIndex != -1 && current >= nums[nextIndex]) { // есть элемент больше
                    nextIndex = indexes[nextIndex];
                }
                if (nextIndex == -1) {
                    dp[i] = 1;
                    indexes[i] = -1;

                } else {
                    dp[i] = dp[nextIndex] + 1;
                    indexes[i] = nextIndex;
                    currentMax = Math.max(dp[i], currentMax);
                }
            }
        }

        return currentMax;
    }


    // TODO: 7/30/23 все три метода реализуют одно и то же
    public int lengthOfLIS_wtf(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;

        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size)
                ++size;
        }

        return size;
    }

    public int lengthOfLIS_binary(int[] nums) {
        int[] dp = new int[nums.length];
        int dpLength = 0;

        for (int currentNumber : nums) {
            int i = Arrays.binarySearch(dp, 0, dpLength, currentNumber);

            if (i < 0)
                i = -(i + 1);

            dp[i] = currentNumber;

            if (i == dpLength) // добавили в конец
                dpLength++;
        }

        return dpLength;
    }

    public int lengthOfLIS_binary2(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int currentLength = 0;

        for (int i = 1; i < nums.length; i++) {

            int currentNum = nums[i];

            int pos = binarySearch(dp, currentLength, currentNum); // ищем позицию в элементах

            if (dp[pos] > currentNum) // замена в массиве бОльшего элемента на текущий меньший
                dp[pos] = currentNum;

            if (pos > currentLength) { // обновить длинну и поставить в конец новое число
                currentLength = pos;
                dp[currentLength] = currentNum;
            }
        }
        return currentLength + 1; // потому что currentLength это индекс
    }

    private int binarySearch(int[] dp, int currentLength, int currentNum) {

        int left = 0;
        int right = currentLength; // правая граница

        while (left + 1 < right) { // dp >= 2
            int mid = left + (right - left) / 2;

            if (dp[mid] == currentNum) {
                return mid;
            } else {
                if (dp[mid] < currentNum) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (dp[right] < currentNum) // число больше крайнего правого
            return currentLength + 1;

        else if (dp[left] >= currentNum) // left больше числа (встает на его место)
            return left;
        else
            return right;
    }
}
