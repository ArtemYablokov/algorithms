package com.yablokovs.leetcode.backtracking;

public class WordSearch79 {
    boolean[][] visited;
    int height;
    int width;

    String localWord;

    public boolean solution(char[][] board, String word) {

        height = board.length;
        width = board[0].length;
        visited = new boolean[height][width];

        localWord = word;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (findWord(i, j, 0, board)) return true;
            }
        }
        return false;
    }

    private boolean findWord(int y, int x, int pointer, char[][] matrix) {
        if (localWord.length() == pointer) {
            return true;
        }
        if (y < 0 || y >= height || x < 0 || x >= width || localWord.charAt(pointer) != matrix[y][x] || visited[y][x]) {
            return false;
        }

        visited[y][x] = true;
        boolean rightPath =
                findWord(y + 1, x, pointer + 1, matrix) ||
                findWord(y - 1, x, pointer + 1, matrix) ||
                findWord(y, x + 1, pointer + 1, matrix) ||
                findWord(y, x - 1, pointer + 1, matrix);

        visited[y][x] = false;

        return rightPath;
    }
}