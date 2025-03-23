package com.yablokovs.leetcode.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FruitIntoBasketTest {

    @Test
    void totalFruit() {
        FruitIntoBasket fruitIntoBasket = new FruitIntoBasket();
        fruitIntoBasket.totalFruit(new int[]{1,0,3,4,3});
    }
}