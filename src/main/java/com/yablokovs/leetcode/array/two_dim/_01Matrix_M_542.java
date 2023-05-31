package com.yablokovs.leetcode.array.two_dim;

import java.util.ArrayList;
import java.util.List;

public class _01Matrix_M_542 {

    public static void main(String[] args) {
        List<int[]> visited = new ArrayList<>();
        System.out.println(visited.size() == 0);
    }

    private static final Integer outOfBound = Integer.MAX_VALUE;
    private static final boolean found = false;

    public int[][] updateMatrix(int[][] mat) {
        int length = mat.length;
        return mat;

    }

    private static List<int[]> recursive(int[][] mat, int i, int j, int length) {
        if (i < 0 || i == length || j < 0 || j == length) return null; // если вышли за пределы
        if (found) return null;


        if (mat[i][j] < 0) return Math.abs(mat[i][j]); // уже вычисленно

        if (mat[i][j] == 0) return null;

        // calls recursive 4-times

        int minPath = -1 * (Math.min(0, 1) + 1); // пометить минусом вычисленные
        mat[i][j] = minPath;
        return minPath; // вернуть наименьшее из 4-х путей
    }
}
