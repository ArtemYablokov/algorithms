package com.yablokovs.LC_v3.SW;

public class LongestNiceSubarray_2401 {
    public int longestNiceSubarray(int[] nums) {
        System.out.println(Integer.toBinaryString(48));
        int[] shift = new int[31];
        int t = 1;
        for (int i = 0; i < 31; i++) {
            shift[i] = t;
            t <<= 1;
        }

        int[] count = new int[31];
        int exceed = 0;
        int ix = 0;
        // int j = 0;
        int l = nums.length;
        int max = 0;
        for (int j = 0; j < l; j++) {
            int cur = nums[j];
            for (int i = 0; i < 31; i++) {
                if ((cur & shift[i]) > 0) {
                    count[i]++;
                    if (count[i] > 1)
                        exceed++;
                }
            }


            while (exceed > 0) {
                cur = nums[ix];
                for (int i = 0; i < 31; i++) {
                    if ((cur & shift[i]) > 0) {
                        count[i]--;
                        if (count[i] == 1)
                            exceed--;
                    }
                }
                ix++;
            }

            if (j - ix + 1 > max)
                max = j - ix + 1;
        }
        return max;
    }

}
