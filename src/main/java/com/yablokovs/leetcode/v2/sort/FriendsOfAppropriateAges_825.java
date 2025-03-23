package com.yablokovs.leetcode.v2.sort;

import java.util.Arrays;

public class FriendsOfAppropriateAges_825 {
    int count = 0;

    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
//        System.out.println(Arrays.toString(ages));

        int l = ages.length;
        int j = 0;
        int i = 0;

        while (j < l) {
            int curAge = ages[j];
            while (ages[i] < curAge && ages[i] <= curAge * 0.5 + 7)
                i++;
            int temp = (j - i); // number of connections with smaller

            int k = j;
            while (k + 1 < l && ages[k + 1] == curAge)
                k++;

            int size = k - j + 1;
            count += size * temp;
            count += computeSame(size);

            j = k + 1;

        }

        return count;
    }

    int[] fib = new int[20_001];
    int point = 1;

    private int computeSame(int num) {
        if (num <= point)
            return fib[num] * 2;
        else {
            for (int i = point + 1; i <= num; i++) {
                fib[i] = fib[i - 1] + (i - 1);
            }
            point = num;
            return fib[num] * 2;
        }

    }
}

// 30, 31, 31, 31

// 0 1 3 6 10 15 21 27

// NOT
// if other is half younger
// if OLDER
//
// age[y] > 100 > age[x] - NOT RELEVANT

