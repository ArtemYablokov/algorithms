package com.yablokovs.leetcode.tree.tree_math;



import java.util.Random;

public class TreeMathGenerator {

    private static final String[] OPERATORS = {"+", "-", "*"};


    public Node generateEquationTree(int depth, String operatorPrev) {
        Random random = new Random();
        if (depth == 0) {
            // Generate a leaf node with a random number between 1 and 10
            int operand = random.nextInt(-10, 20);
            if (operatorPrev.equals("-"))
                operand = Math.abs(operand);
            return new Node(String.valueOf(operand));
        } else {
            // Generate an internal node with a random operator
            String operator = OPERATORS[random.nextInt(OPERATORS.length)];
            Node node = new Node(operator);
            node.left = generateEquationTree(depth - 1, operator);
            node.right = generateEquationTree(depth - 1, operator);
            return node;
        }
    }


    public Node generateEquationTree2(int depth) {
        Random random = new Random();

        if (depth == 0) {
            // Generate a leaf node with a random number between 1 and 10
            int operand = random.nextInt(-5, 20);
            return new Node(String.valueOf(operand));
        }

        // Generate an internal node with a random operator
        String operator = OPERATORS[random.nextInt(OPERATORS.length)];

        Node node = new Node(operator);
        node.left = generateEquationTree2(depth - 1);

        if (operator.equals("-")) {
            // Ensure the right child of subtraction is positive
            node.right = generateEquationTree2(depth - 1);
            while (isOperator(node.right.value) || Integer.parseInt(node.right.value) < 0) {
                node.right = generateEquationTree2(depth - 1);
            }
        } else {
            node.right = generateEquationTree2(depth - 1);
        }

        return node;

    }

    private boolean isOperator(String token) {
        for (String operator : OPERATORS) {
            if (operator.equals(token)) {
                return true;
            }
        }
        return false;
    }
}

