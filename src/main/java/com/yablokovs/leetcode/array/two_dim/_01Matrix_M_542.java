package com.yablokovs.leetcode.array.two_dim;

public class _01Matrix_M_542 {

    public static void main(String[] args) {
        int[][] source = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] source2 = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        int[][] source3 = {{0}, {0}, {0}};

        int[][] ints = updateMatrix(source3);

        int n = 0;
    }

    private static int notZeroCounter = 0;

    public static int[][] updateMatrix(int[][] mat) {
        int len = mat.length;
        int high = mat[0].length;


        int[][] distance = new int[len][high];
        int initialNumber = 0;

        // fill up matrix with 0 or -1
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < high; j++) {
                if (mat[i][j] == 0)
                    distance[i][j] = 0;
                else {
                    distance[i][j] = -1;
                    notZeroCounter++;
                }
            }
        }
        while (notZeroCounter > 0) {
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < high; j++) {
                    int current = distance[i][j];
                    if (current == initialNumber)
                        setupAllNearCell1Distance(i, j, initialNumber, distance, len, high);
                }
            }
            initialNumber++;
        }
        return distance;
    }

    private static void setupAllNearCell1Distance(int i, int j, int initialNumber, int[][] distance, int length, int high) {
        int up = j - 1;
        int down = j + 1;
        int left = i - 1;
        int right = i + 1;

        setValue(left, j, initialNumber, distance, length, high);
        setValue(right, j, initialNumber, distance, length, high);
        setValue(i, up, initialNumber, distance, length, high);
        setValue(i, down, initialNumber, distance, length, high);
    }

    private static void setValue(int i, int j, int initialNumber, int[][] distance, int length, int high) {
        if (!outOfBounds(i, j, length, high)) {
            int current = distance[i][j];
            if (current == -1) {
                distance[i][j] = initialNumber + 1;
                notZeroCounter--;
            }
        }
    }

    private static boolean outOfBounds(int x, int y, int length, int high) {
        return x < 0 || y < 0 || x == length || y == high;
    }

    private class Tuple {
        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;
    }

}
