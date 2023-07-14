package com.yablokovs.leetcode.array.two_dim;

import java.util.Deque;
import java.util.LinkedList;

public class RottingOranges_M_994 {

    public int orangesRotting(int[][] grid) {
        Deque<int[]> deque = new LinkedList<>();
        int length = grid.length;
        int high = grid[0].length;
        int oneCounter = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < high; j++) {
                int current = grid[i][j];
                if (current == 2) {
                    deque.addLast(new int[]{i, j});
                }
                if (current == 1)
                    oneCounter++;
            }
        }
        return rottenByRound(deque, grid, length, high, oneCounter);
    }

    private int rottenByRound(Deque<int[]> deque, int[][] grid, int length, int high, int oneCounter) {
        int counter = -1;

        while (deque.size() > 0) {
            counter++;
            int size = deque.size();
            for (int k = 0; k < size; k++) {
                int[] current = deque.remove();

                int i = current[0];
                int j = current[1];

                int left = i - 1;
                int right = i + 1;
                int up = j - 1;
                int down = j + 1;

                if (tryRotten(deque, grid, length, high, j, left))
                    oneCounter--;
                if (tryRotten(deque, grid, length, high, j, right))
                    oneCounter--;
                if (tryRotten(deque, grid, length, high, up, i))
                    oneCounter--;
                if (tryRotten(deque, grid, length, high, down, i))
                    oneCounter--;
            }
        }
        if (counter == -1 && oneCounter == 0) return 0;

        return oneCounter == 0 ? counter : -1;
    }

    private boolean tryRotten(Deque<int[]> deque, int[][] grid, int length, int high, int j, int i) {
        if (i > -1 && i < length && j > -1 && j < high && grid[i][j] == 1) {
            grid[i][j] = 2;
            deque.addLast(new int[]{i, j});
            return true;
        }
        return false;
    }

    private boolean checkThatIsOne(int[][] grid, int i, int j, int length, int high) {
        return i > -1 && i < length && j > -1 && j < high && grid[i][j] == 1;
    }
}
