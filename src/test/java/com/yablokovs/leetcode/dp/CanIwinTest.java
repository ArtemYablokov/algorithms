package com.yablokovs.leetcode.dp;

import org.junit.jupiter.api.Test;

class CanIwinTest {

    @Test
    void canIWin() {
        CanIwin canIwin = new CanIwin();
        String format = canIwin.format(new char[]{'1', '0', '1'});
        int i5 = modifyState(false, 7, 2);
        int i3 = modifyState(false, 2, 3);

        int i1 = canIwin.checkState(3, 1);

        int i = Integer.parseInt(format, 2);
        String string = Integer.toBinaryString(i);


        boolean b = canIwin.canIWin(3, 4);
    }

    private int modifyState(boolean add, int state, int position) {
        int ix = 1 << position - 1;

        if (add) state |= ix;
        else state ^= ix;

        return state;
    }
}