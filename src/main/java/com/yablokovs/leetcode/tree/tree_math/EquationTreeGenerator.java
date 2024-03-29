package com.yablokovs.leetcode.tree.tree_math;

import java.util.Random;

public class EquationTreeGenerator {

    private static final String[] OPERATORS = {"+", "-", "*"};

    public Node generateEquationTree(int depth, String operatorPrev) {
        Random random = new Random();
        if (depth == 0) {
            // Generate a leaf node with a random number between 1 and 10
            int operand = random.nextInt(-10, 20);
            if (operatorPrev.equals("-")) operand = Math.abs(operand);
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
            int operand = random.nextInt(-10, 20);
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


    public int solveEquationTree(Node root) {
        if (root == null) {
            return 0;
        }

        if (!isOperator(root.value)) {
            // Leaf node represents an operand, parse and return its value
            return Integer.parseInt(root.value);
        }

        int leftResult = solveEquationTree(root.left);
        int rightResult = solveEquationTree(root.right);

        // Apply the operator on the left and right sub-expressions
        switch (root.value) {
            case "+":
                return leftResult + rightResult;
            case "-":
                rightResult = -1 * Math.abs(rightResult); // Negate the right operand
                return leftResult + rightResult;
            case "*":
                return leftResult * rightResult;
            default:
                throw new IllegalArgumentException("Invalid operator: " + root.value);
        }
    }

    public String printTree(Node node) {
        if (node == null) {
            return "";
        }

        if (!isOperator(node.value)) {
            // Leaf node represents an operand
            return node.value;
        }

        String leftExpression = printTree(node.left);
        String rightExpression = printTree(node.right);

        // Check if brackets are needed based on operator precedence
        if (isOperator(node.left.value) && getOperatorPrecedence(node.left.value) < getOperatorPrecedence(node.value)) {
            leftExpression = "(" + leftExpression + ")";
        }
        if (isOperator(node.right.value) && getOperatorPrecedence(node.right.value) < getOperatorPrecedence(node.value)) {
            rightExpression = "(" + rightExpression + ")";
        }

        return leftExpression + " " + node.value + " " + rightExpression;
    }

    private int getOperatorPrecedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
                return 2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }


    public String printTreeAllBrackets(Node node) {
        if (node == null) {
            return "";
        }

        if (!isOperator(node.value)) {
            // Leaf node represents an operand
            return node.value;
        }

        String leftExpression = printTreeAllBrackets(node.left);
        String rightExpression = printTreeAllBrackets(node.right);

        // Add brackets around sub-expressions if necessary
        if (isOperator(node.left.value)) {
            leftExpression = "(" + leftExpression + ")";
        }
        if (isOperator(node.right.value)) {
            rightExpression = "(" + rightExpression + ")";
        }

        return leftExpression + " " + node.value + " " + rightExpression;
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
