package com.yablokovs.leetcode.array.two_dim;

public class NumberOfIslands_M_200 {

    public int numIslands(char[][] grid) {
        // 48 = 0 49 = 1 50 = 2
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int current = grid[i][j];
                if (current == 48 || current == 50)
                    continue;
                counter++;
                markIsland(grid, i, j, grid.length, grid[0].length);
            }
        }
        return counter;
    }


    private void markIsland(char[][] grid, int i, int j, int length, int high) {
        int left = i - 1;
        int right = i + 1;
        int up = j - 1;
        int down = j + 1;

        if (left >= 0 && grid[left][j] == 49) {
            grid[left][j] = 50;
            markIsland(grid, left, j, length, high);
        }
        if (right < length && grid[right][j] == 49) {
            grid[right][j] = 50;
            markIsland(grid, right, j, length, high);
        }
        if (up >= 0 && grid[i][up] == 49) {
            grid[i][up] = 50;
            markIsland(grid, i, up, length, high);
        }
        if (down < high && grid[i][down] == 49) {
            grid[i][down] = 50;
            markIsland(grid, i, down, length, high);
        }
    }

}
