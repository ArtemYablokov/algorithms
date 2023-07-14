package com.yablokovs.leetcode.tree.stack_math.signs;

public class CloseBracket implements Sign {

    private static Character value = ')';

    public static Character getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
