package com.yablokovs.leetcode.array.two_dim;

import org.junit.jupiter.api.Test;

class NumberOfIslandsM200Test {

    @Test
    void numIslands() {

        char[][] data =  {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};

        NumberOfIslands_M_200 numberOfIslandsM200 = new NumberOfIslands_M_200();
        numberOfIslandsM200.numIslands(data);

    }
}