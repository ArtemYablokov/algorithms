package com.yablokovs.leetcode.tree.tree_math;

import org.junit.jupiter.api.Test;

class EquationTreeGeneratorTest {

    @Test
    void generateEquationTree() {

        EquationTreeGenerator equationTreeGenerator = new EquationTreeGenerator();

        int depth = 3;
        Node tree = equationTreeGenerator.generateEquationTree(depth, "+");

        String string = equationTreeGenerator.printTree(tree);
        int i = equationTreeGenerator.solveEquationTree(tree);

        int n = 0;
    }
}