package com.yablokovs.leetcode.math;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class MaximumSwap {
    public int maximumSwap(int num) {

//        Map<Integer, Integer> map = new HashMap<>();
//        map.compute(1, k -> 0);

        Stack<int[]> q = new Stack<>(); // val to index

        int count = 0;
        int temp = num;
        while (temp > 0) {

            int val = temp % 10;


            if (q.isEmpty() || q.peek()[0] < val)
                q.add(new int[]{val, count});

            count++;
            temp = temp / 10;
        }
        count--;

        int top = -1;
        int bottom = -1;

        int topNum = -1;
        int bottomNum = -1;

        int ix = count;
        temp = num;
        while (!q.isEmpty()) {
            if (q.peek()[1] == ix) {
                q.pop();
                // ix--;
            } else if (temp / (int) Math.pow(10, ix) < q.peek()[0]) {
                top = ix;
                topNum = temp / (int) Math.pow(10, ix);
                bottom = q.peek()[1];
                bottomNum = q.peek()[0];
                break;
            }
            temp -= (temp / (int) Math.pow(10, ix)) * (int) Math.pow(10, ix);

            ix--;
        }

        if (top != -1) {
            int topVal = topNum * (int) Math.pow(10, top);
            num -= topVal;
            int bottomVal = bottomNum * (int) Math.pow(10, bottom);
            num -= bottomVal;

            topVal = bottomNum * (int) Math.pow(10, top);
            num += topVal;
            bottomVal = topNum * (int) Math.pow(10, bottom);
            num += bottomVal;

        }

        return num;

    }
}
