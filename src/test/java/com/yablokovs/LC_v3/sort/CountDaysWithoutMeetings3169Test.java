package com.yablokovs.LC_v3.sort;

import com.yablokovs.LC_v3.util.Util;
import org.junit.jupiter.api.Test;

class CountDaysWithoutMeetings3169Test {

    @Test
    void countDays() {
        CountDaysWithoutMeetings_3169 solution = new CountDaysWithoutMeetings_3169();
        int i = solution.countDays(10, Util.build2d("[[1,3],[5,7],[1,2],[9,10]]"));
    }
}