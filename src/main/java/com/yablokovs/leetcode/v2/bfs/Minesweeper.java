package com.yablokovs.leetcode.v2.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Minesweeper {
    boolean[][] visited;
    int h;
    int l;
    char[][] mx;

    int[][] moves = new int[][] {{1, 1}, {0, 1}, {0, -1}, {1, -1}, {-1, 1}, {-1, -1}, {-1, 0}, {1, 0}};

    public char[][] updateBoard(char[][] board, int[] click) {
        int init = click[0];
        int jnit = click[1];
        if (board[init][jnit] == 'M' ) {
            board[init][jnit] = 'X';
            return board;
        }
        mx = board;
        h = mx.length;
        l = mx[0].length;
        visited = new boolean[h][l];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{init, jnit});
        visited[init][jnit] = true;

        while (q.size() != 0) {
            int[] cur = q.poll(); // can't be M since we are checking near number-cells
            int i = cur[0];
            int j = cur[1];

            if (mx[i][j] == 'M')
                continue;
            int mines = countMines(i, j);
            if (mines > 0) {
                mx[i][j] = (char) (mines + '0');
                continue;
            }
            mx[i][j] = 'B';
            addNeighbours(i,j,q);
        }

        return mx;
    }
    private void addNeighbours(int i, int j, Queue<int[]> q) {
        for (int[] m : moves) {
            int ix = i + m[0];
            int jx = j + m[1];

            if (ix < 0 || jx < 0 || ix >= h || jx >= l || visited[ix][jx])
                continue;
            q.offer(new int[] {ix, jx});
            visited[ix][jx] = true;

        }
    }

    private int countMines(int i, int j) {
        int count = 0;
        for (int[] m : moves) {
            int ix = i + m[0];
            int jx = j + m[1];
            if (ix < 0 || jx < 0 || ix >= h || jx >= l )
                continue;
            if ( mx[ix][jx] == 'M') count++;
        }
        return count;
    }
}

// each empty revealed near empty E->B
// if has near MINES -> change to number E->1

