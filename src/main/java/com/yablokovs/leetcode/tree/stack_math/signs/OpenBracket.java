package com.yablokovs.leetcode.tree.stack_math.signs;

public class OpenBracket implements Sign {
    private static Character value = '(';

    public static Character getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
