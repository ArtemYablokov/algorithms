package com.yablokovs.leetcode.v2.sw;

public class NumberOfSubarrays_1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int l = arr.length;
        float[] av = new float[l];
        for (int i = 0; i < l; i++) {
            av[i] = (float) arr[i] / k;
        }
        float sum = 0.0f;
        int j;
        for (j = 0; j < k; j++) {
            sum += av[j];
        }
        j--;
        int i = 0;
        int result = 0;
        while (true) {
            if (sum >= threshold)
                result++;
            if (j == l - 1)
                break;
            sum += av[++j];
            sum -= av[i++];
        }
        return result;
    }
}
