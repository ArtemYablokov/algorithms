package com.yablokovs.LC_v3.mono;

import java.util.LinkedList;

public class UsingaRobottoPrinttheLexicographicallySmallestString_2434 {


    public String robotWithString(String s) {
        int l = s.length();
        char[] a = s.toCharArray();
        if (l == 1)
            return s;

        LinkedList<Integer> mono = new LinkedList<>();
        // it will contains indexes of non-decreasing chars
        for (int i = 0; i < l; i++) {
            while (!mono.isEmpty() && a[mono.peek()] > a[i]) {
                mono.pop();
            }
            mono.push(i);
        }

        StringBuilder res = new StringBuilder();

        LinkedList<Character> holder = new LinkedList<>();

//            if (mono.size() > 1) mono.pop();
        int prev = 0;
        while (mono.size() > 1) {
            int ix = mono.removeLast(); // LEFT MOST
            for (int i = prev; i < ix; i++) {
                holder.push(a[i]);
            }

            prev = ix + 1;
            res.append(a[ix]);
        }

        for (int i = prev; i < mono.peek(); i++) {
            holder.push(a[i]);
        }
        prev = mono.peek();

        while (!holder.isEmpty() && prev < l) {
            if (holder.peek() < a[prev]) {
                res.append(holder.pop());
            } else {
                res.append(a[prev++]);
            }
        }

        while (!holder.isEmpty()) {
            res.append(holder.pop());
        }
        while (prev < l) {
            res.append(a[prev++]);
        }

        return res.toString();

    }
}

// first S -> last T
// last T -> first RESULT


