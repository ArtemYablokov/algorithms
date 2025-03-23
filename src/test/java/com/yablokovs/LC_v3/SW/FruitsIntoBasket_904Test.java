package com.yablokovs.LC_v3.SW;

import com.yablokovs.LC_v3.util.Util;
import org.junit.jupiter.api.Test;

class FruitsIntoBasket_904Test {

    public static final int[] TEST = Util.build(1, 9, 1, 8, 22, 0, 22, 19, 19, 2, 19, 6, 6, 19, 2, 20, 2, 9, 9, 9, 9, 16, 19, 16, 19, 11, 19, 0, 19, 19);
    FruitsIntoBasket_904 fruitsIntoBasket904 = new FruitsIntoBasket_904();

    @Test
    void totalFruitNum() {
        int result = fruitsIntoBasket904.totalFruitNum(TEST);
        System.out.println(result);

    }

    @Test
    void totalFruitIx() {
        int result = fruitsIntoBasket904.totalFruitIx(TEST);
        System.out.println(result);
    }

}