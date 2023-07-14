package com.yablokovs.leetcode.tree.stack_math.signs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Digit implements Sign{

    private int value;

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
