package com.yablokovs.leetcode.v2.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesisString_678Test {

    @Test
    void checkValidString() {
        ValidParenthesisString_678 validParenthesisString678 = new ValidParenthesisString_678();

//        boolean b = validParenthesisString678.checkValidString("(((((*)))**");
//        String s = validParenthesisString678.largestNumber(new int[]{56, 525, 52, 57, 5, 5, 54, 53 });
        String s = validParenthesisString678.largestNumber(new int[]{12341,123411234 });
    }
}