package com.yablokovs.LC_v3.math;

public class CountTheNumberOfPowerfulIntegers_2999_HARD {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {

        for (long i = start; i <= finish; i++) {
            if (i % 10 == 1 && check(i)) {
                System.out.println(i);
            }
        }


        return 0L;
    }

    boolean check(long num) {
        char[] chars = Long.toString(num).toCharArray();
        for (char c : chars) {
            if (c > '6') return false;

        }
        return true;
    }

}
