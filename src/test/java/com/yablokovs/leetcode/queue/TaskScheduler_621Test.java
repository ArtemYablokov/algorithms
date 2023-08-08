package com.yablokovs.leetcode.queue;

import org.junit.jupiter.api.Test;

class TaskScheduler_621Test {

    @Test
    void leastInterval() {

        TaskScheduler_621 taskScheduler621 = new TaskScheduler_621();

        int i = taskScheduler621.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'B', 'C', 'D', 'E', 'F', 'G'}, 2);
    }
}