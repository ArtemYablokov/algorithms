package com.yablokovs.leetcode.HARD.string;

public class ClosestPalindromicString {

    public String nearestPalindromic(String n) {
        char[] arr = n.toCharArray();
        int l = arr.length;
        if (l == 1) return n;

        String result;
        if (l % 2 == 0) {
            result = even(arr, l);
        } else
            result = odd(arr, l);

        StringBuilder sb = new StringBuilder();
        for (int i = l / 2 - 2; i > -1 ; i--) {
            sb.append(arr[i]);
        }
        String end = sb.toString();
        sb.reverse();
        sb.append(result);
        sb.append(end);


        return sb.toString();
    }

    private String odd(char[] arr, int l) {
        int f = l / 2 - 1;
        int m = l / 2;
        int s = l / 2 + 1;

        int first = arr[f] - '0';
        int mid = arr[m] - '0';
        int second = arr[s] - '0';

        int cur = first * 100 + mid * 10 + second;

        int down;
        int up;
        if (first == 0) {
            down = 999;
        } else {
            down = (first - 1) * 100 + 90 + first - 1;
        }

        if (first == 9) {
            up = 000;
        } else {
            up = (first + 1) * 100 + 0 + first + 1;
        }
        int center = first * 100 + mid * 10 + first;

        int min = Math.abs(up - cur);
        int result = up;
        if (Math.abs(center - cur) < min) {
            result = center;
            min = Math.abs(center - cur);
        }
        if (Math.abs(down - cur) < min) {
            result = down;
            min = Math.abs(down - cur);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result);
        if (result == 0) sb.append(result);

        return sb.toString();
    }

    private String even(char[] arr, int l) {
        int f = l / 2 - 1;
        int s = l / 2;

        int first = arr[f] - '0';
        int second = arr[s] - '0';

        int cur = first * 10 + second;

        int down;
        if (first == 0) {
            down = 99;
        } else {
            down = (first - 1) * 10 + first - 1;
        }
        int up;
        if (first == 9) {
            up = 00;
        } else {
            up = (first + 1) * 10 + first + 1;
        }
        int middle = first * 10 + first;

        int min = Math.abs(up - cur);
        int result = up;
        if (Math.abs(middle - cur) < min) {
            result = middle;
            min = Math.abs(middle - cur);
        }
        if (Math.abs(down - cur) < min) {
            result = down;
            min = Math.abs(down - cur);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result);
        if (result == 0) sb.append(result);

        return sb.toString();
    }
}
