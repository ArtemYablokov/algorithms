package com.yablokovs.LC_v3.sort;

import java.util.Arrays;
import java.util.Comparator;

public class CountDaysWithoutMeetings_3169 {
    public int countDays(int days, int[][] meetings) {
        int l = meetings.length;
        Arrays.sort(meetings, Comparator.comparing(m -> m[0]));

        int end = -1;

        int res = 0;

        for (int i = 0; i < l; i++) {
            int[] m = meetings[i];
            if (m[1] <= end) {
                continue;
            }

            if (m[0] > end) {
                res += (m[0] - end - 1);
                end = m[1];
            }
            if (m[1] > end) {
                end = m[1];
            }
        }
        if (days > end) {
            res += (days - end);
        }

        return res;
    }
}
