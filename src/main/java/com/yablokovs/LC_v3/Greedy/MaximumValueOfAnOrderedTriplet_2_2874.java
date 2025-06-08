package com.yablokovs.LC_v3.Greedy;

public class MaximumValueOfAnOrderedTriplet_2_2874 {
    public long maximumTripletValue(int[] nums) {
        long result = 0L;
        int l = nums.length;

        int max = nums[0];
        int min = nums[0];
        // PriorityQueue<Integer> pq = new PriorityQueue<>(
        //     (a, b) -> Integer.compare(nums[b], nums[a])
        // );
        // LinkedList<Integer> s = new LinkedList<>();

        // for (int i = l - 1; i >= 2; i--) {
        //     if (s.isEmpty() || nums[i] > nums[s.peek()]) {
        //         s.push(i);
        //     }
        // }

        for (int i = 1; i < l; i++) {
            int cur = nums[i];
            // don't let update simultaneously - it leads to

            long t = (long) cur * (max - min);
            if (t > result)
                result = t;

            if (cur > max) {
                max = cur;
                min = cur; // reset min
                // don't count here
                continue;
            } else if (cur < min) {
                min = cur;

                // while (s.peek() <= i) {
                //     s.pop();
                // }
                // int ix = s.peek();

                // long mult = nums[ix];

            }
        }

        return result;
    }
}
