package com.yablokovs.leetcode.tree.stack_math;

import org.junit.jupiter.api.Test;

class StringMathSolverTest {

    StringMathSolver stringMathSolver = new StringMathSolver();

    @Test
    void generateSimpleNode() {

        String s0 = stringMathSolver.generateMathString(0);
        Integer integer = stringMathSolver.computeString(s0);

        String s1 = stringMathSolver.generateMathString(1);
        Integer integer1 = stringMathSolver.computeString(s1);

        String s2 = stringMathSolver.generateMathString(2);
        Integer integer2 = stringMathSolver.computeString(s2);

        String s3 = stringMathSolver.generateMathString(3);
        Integer integer3 = stringMathSolver.computeString(s3);

        String s4 = stringMathSolver.generateMathString(4);
        Integer integer4 = stringMathSolver.computeString(s4);

        String s5 = stringMathSolver.generateMathString(5);
        Integer integer5 = stringMathSolver.computeString(s5);

        String s6 = stringMathSolver.generateMathString(6);
        Integer integer6 = stringMathSolver.computeString(s6);

        String s7 = stringMathSolver.generateMathString(7);
        Integer integer7 = stringMathSolver.computeString(s7);

        String s8 = stringMathSolver.generateMathString(8);
        Integer integer8 = stringMathSolver.computeString(s8);

        String s9 = stringMathSolver.generateMathString(9);
        Integer integer9 = stringMathSolver.computeString(s9);

        String s10 = stringMathSolver.generateMathString(10);
        Integer integer0 = stringMathSolver.computeString(s10);


        int n = 0;

    }

    // - это операция когда перед ним число или закрытая скобка(в моем случае невозможно)
    // если открытая скобка или другая операция - то число


    @Test
    void fillUpDeque() {
        // TODO: 7/11/23 minus воспринимает как число
        Integer signs2 = stringMathSolver.computeString("6-2"); // TODO: 7/13/23 -2 not a DIGIT

        Integer signs3 = stringMathSolver.computeString("6--2");
        Integer signs4 = stringMathSolver.computeString("10/-2");
        Integer signs5 = stringMathSolver.computeString("4-(-2)");

        Integer signs = stringMathSolver.computeString("3+(1+2*4/2*2)+(10)/-2*(4-(-2))");
        int n = 0;
    }

}