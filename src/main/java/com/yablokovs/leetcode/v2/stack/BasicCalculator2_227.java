package com.yablokovs.leetcode.v2.stack;

import java.util.LinkedList;

public class BasicCalculator2_227 {
    int l;

    public int calculate(String s) {
        int ix = 0;
        char[] ch = s.toCharArray();
        l = ch.length;
        LinkedList<Object> stack = new LinkedList<>();
        while (ix < l) {
            char cur = ch[ix];
            if (cur == ' ') {
                ix++;
                continue;
            }
            if (cur == '+' || cur == '-' || cur == '*' || cur == '/') {
                stack.push(cur);
                ix++;
                continue;
            }
            int[] a = read(ch, ix);
            stack.push(a[0]);
            ix = a[1];
        }
        LinkedList<Object> stack2 = new LinkedList<>();

        while (!stack.isEmpty()) {
            Object o = stack.removeLast();
            if (o instanceof Integer) {
                if (!stack2.isEmpty() && ((char) stack2.peek() == '*' || (char) stack2.peek() == '/')) {
                    char sign = (char) stack2.pop();
                    int prev = (int) stack2.pop();
                    if (sign == '*')
                        stack2.push((int) o * prev);
                    else
                        stack2.push(prev / (int) o);
//                    System.out.println();
                } else {
                    stack2.push(o);
                }
            } else
                stack2.push(o);
        }
        while (stack2.size() > 1) {
            int left = (int) stack2.removeLast();
            char sign = (char) stack2.removeLast();
            int right = (int) stack2.removeLast();
            int t;
            if (sign == '+')
                t = left + right;
            else
                t = left - right;
            stack2.addLast(t);
        }

        return (int) stack2.pop();
    }


    private int[] read(char[] ch, int ix) {
        StringBuilder sb = new StringBuilder();
        while (ix < l && ch[ix] >= '0' && ch[ix] <= '9') {
            sb.append(ch[ix]);
            ix++;
        }
        return new int[]{Integer.parseInt(sb.toString()), ix};
    }

}
