package com.yablokovs.leetcode.tree.stack_math.signs;

import java.util.Arrays;
import java.util.List;

public enum Operations implements Sign {

    MINUS('-'),
    PLUS('+'),
    MULTIPLY('*'),
    DIVIDE('/');

    public final Character value;

    private Operations(Character s) {
        this.value = s;
    }

    public static Operations getByValue(Character s) {
        for (Operations e : values()) {
            if (e.value.equals(s)) {
                return e;
            }
        }
        return null;
    }

    public static List<Character> getAll() {
        return Arrays.stream(values()).map(o -> o.value).toList();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
