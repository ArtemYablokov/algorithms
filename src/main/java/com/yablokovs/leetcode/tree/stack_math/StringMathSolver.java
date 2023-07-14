package com.yablokovs.leetcode.tree.stack_math;

import com.yablokovs.leetcode.tree.stack_math.signs.Digit;
import com.yablokovs.leetcode.tree.stack_math.signs.OpenBracket;
import com.yablokovs.leetcode.tree.stack_math.signs.Operations;
import com.yablokovs.leetcode.tree.stack_math.signs.Sign;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.BiFunction;

public class StringMathSolver {
    private Map<Operations, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();
    Random random = new Random();
    private static final Map<Operations, Integer> OPS_PRIORITY = new HashMap<>();
    private static final Set<Character> DIGITS_LIST = new HashSet<>(List.of('1', '2', '3', '4', '5', '6', '7', '8', '9', '0'));

    public StringMathSolver() {
        operations.put(Operations.PLUS, Integer::sum);
        operations.put(Operations.MINUS, (m, n) -> m - n);
        operations.put(Operations.MULTIPLY, (m, n) -> m * n);
        operations.put(Operations.DIVIDE, (m, n) -> m / n);

        OPS_PRIORITY.put(Operations.MINUS, 0);
        OPS_PRIORITY.put(Operations.PLUS, 0);
        OPS_PRIORITY.put(Operations.MULTIPLY, 1);
        OPS_PRIORITY.put(Operations.DIVIDE, 2);
    }

    public Integer computeString(String math) {
        Deque<Sign> stackOfSigns = new LinkedList<>();

        int i = 0;
        char[] chars = math.toCharArray();

        while (i < chars.length) {
            char current = chars[i];

            if (DIGITS_LIST.contains(current)
                    || (current == Operations.MINUS.value
                    && DIGITS_LIST.contains(chars[i + 1])

                    /*&& stackOfSigns.getLast() instanceof Operations*/)) {
                // DIGIT

                i = getOperand(stackOfSigns, i, chars);
            } else if (Operations.getAll().contains(current)) { // OPERATOR
                Sign last = stackOfSigns.getLast();
                if (last instanceof Operations) {
                    throw new RuntimeException("can't assign to " + last + " another operator");
                }
                Operations operation = Operations.getByValue(chars[i++]);
                stackOfSigns.addLast(operation);
            } else if (current == OpenBracket.getValue()) {
                stackOfSigns.addLast(new OpenBracket());
                i++;
            } else { // CloseBracket
                Deque<Sign> stackInsideBrackets = getStackInsideBrackets(stackOfSigns);
                Integer integer = computeStackWithoutBrackets(stackInsideBrackets);
                stackOfSigns.addLast(new Digit(integer));
                i++;
            }
        }
        return computeStackWithoutBrackets(stackOfSigns);

    }

    public Integer computeStackWithoutBrackets(Deque<Sign> stackOfSigns) {
        if (stackOfSigns.size() > 1) {
            int n = 0;
        }

        Deque<Sign> result = new LinkedList<>();

        while (stackOfSigns.size() > 1) {

            Digit currentDigit = (Digit) stackOfSigns.pollFirst();
            Operations currentOperation = (Operations) stackOfSigns.pollFirst();
            Digit nextDigit = (Digit) stackOfSigns.pollFirst();
            Operations nextOperation = (Operations) stackOfSigns.pollFirst();

            while (nextOperation != null) {
                if ((OPS_PRIORITY.get(currentOperation) >= OPS_PRIORITY.get(nextOperation)) || nextOperation == null) {
                    Integer num = operations.get(currentOperation).apply(currentDigit.getValue(), nextDigit.getValue());
                    currentDigit = new Digit(num);
                } else {
                    result.addLast(currentDigit);
                    result.addLast(currentOperation);
                    currentDigit = nextDigit;
                }
                currentOperation = nextOperation;

                nextDigit = (Digit) stackOfSigns.pollFirst();
                nextOperation = (Operations) stackOfSigns.pollFirst();
            }
            Integer apply = operations.get(currentOperation).apply(currentDigit.getValue(), nextDigit.getValue());
            stackOfSigns.addFirst(new Digit(apply));

            while (!result.isEmpty()) {
                stackOfSigns.addFirst(result.pollLast());
            }
        }

        return ((Digit) stackOfSigns.pollFirst()).getValue();
    }

    public Deque<Sign> getStackInsideBrackets(Deque<Sign> stackOfSigns) {
        Deque<Sign> inBrackets = new LinkedList<>();
        Sign last = stackOfSigns.pollLast();

        while (!(last instanceof OpenBracket)) {
            inBrackets.addFirst(last);
            last = stackOfSigns.pollLast();
        }
        return inBrackets;
    }

    private int getOperand(Deque<Sign> localStack, int i, char[] chars) {
        char first = chars[i];
        i++;
        StringBuilder sb = new StringBuilder();
        sb.append(first);

        while (i < chars.length && DIGITS_LIST.contains(chars[i])) {
            sb.append(chars[i]);
            i++;
        }
        int operand = Integer.parseInt(sb.toString());
        localStack.addLast(new Digit(operand));
        return i;
    }

    public String generateMathString(int numberOfOperators) {
        List<Character> allOperations = Operations.getAll();

        String result;

        if (numberOfOperators == 0) {
            int i = random.nextInt(-5, 20);
            result = String.valueOf(i);

            int rand = random.nextInt(3);
            if (i < 0 && rand < 2) {
                result = addBrackets(result);
            }

        } else {
            Character operator = allOperations.get(random.nextInt(allOperations.size()));

            int numberLeftInBranch = (numberOfOperators) / 2;
            String left = generateMathString(numberLeftInBranch);
            String right = generateMathString(numberOfOperators - 1 - numberLeftInBranch);

            if (operator.equals('-') && right.startsWith("-")) {
                right = addBrackets(right);
            }
            if (operator.equals('/')) {
                // right != 0 if ( OR 1st element != 0
                right = checkNotZero(right, numberOfOperators - 1 - numberLeftInBranch);

                while (computeString(left) % computeString(right) != 0) {
                    left = generateMathString(numberLeftInBranch);
                }
            }
            result = left + operator + right;


            int rand = random.nextInt(3);
            if (rand < 2) {
                result = addBrackets(result);
            }

        }

        return result;
    }

    private String checkNotZero(String right, int numberOfOperators) {
        String result = right;
        if (right.charAt(0) == OpenBracket.getValue()) {
            while (computeString(right) == 0) {
                result = generateMathString(numberOfOperators);
            }
        } else if (right.charAt(0) == 0) {
            while (right.charAt(0) == 0) {
                result = generateMathString(numberOfOperators);
            }
        }

        return result;
    }

    private static String addBrackets(String s) {
        return "(" + s + ")";
    }


}
