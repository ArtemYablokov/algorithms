package com.yablokovs.leetcode.dynamic;

public class ClimbingStairs_E_70 {


    public static void main(String[] args) {
        int factorial = factorial(5);
        int i = countC(5, 3);

        int n = 0;
    }

    public int climbingStairsFib2(int n) {
        if (n < 3) return n;


        int current = 0;
        int _2before = 1;
        int _1before = 2;

        for (int i = 2; i < n; i++) {
            current = _2before + _1before;
            _2before = _1before;
            _1before = current;
        }


        return current;
    }

    public int climbStairsFibonacci(int n) {
        if (n == 1) return 1;

        int first = 1;
        int second = 2;

        for (int i = 2; i < n; i++){
            second += first;
            first = second - first;
        }

        return second;
    }

    public int climbStairsMemoization(int n) {
        if (n == 1) return 1;

        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;

        for (int i = 2; i < n; i++){

            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n - 1];
    }

    // n = 3
    // max2steps = 1
    // possiblePositions = 2
    // TODO: 4/15/23 COMBINATORIC -->> WRONG :)))))
    public int climbStairs(int n) {

        int max2steps = n / 2;
        int possiblePositions = n - 1;
        int answer = 0;

        for (int i = 1; i < max2steps; i++) {
            int currentC = countC(possiblePositions, i);
            answer += (currentC / 2);
        }
        answer++;

        return answer;
    }

    private static int countC(int n, int k) {
        int downL = factorial(k);
        int downR = factorial(n - k);
        return factorial(n) / (downL * downR);
    }

    private static int factorial(int n) {
        if (n == 0) return 1;
        int result = 1;
        for (int i = 1; i < n + 1; i++) {
            result *= i;
        }
        return result;
    }
}
