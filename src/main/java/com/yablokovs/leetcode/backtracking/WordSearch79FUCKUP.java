package com.yablokovs.leetcode.backtracking;

import java.util.HashSet;
import java.util.Set;

public class WordSearch79FUCKUP {

    public static void main(String[] args) {

        String word = "abcx";
        String leetword = "ABCCED";
        char[][] leet = new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        char[][] chars = new char[][]{{'a', 'd', 'f'}, {'b', 'c', 'z'}, {'z', 'x', 'z'}};
        boolean solution = solution(leet, leetword);

        int n = 0;
    }

    public static boolean solution(char[][] board, String word) {
        int length = board[0].length;
        int height = board.length;

        char[] wordAsChar = word.toCharArray();
        char firstSymbol = wordAsChar[0];

        for (int i = 0; i < height; i++) {
            char[] currentRaw = board[i];
            for (int j = 0; j < length; j++) {
                char currentChar = currentRaw[j];
                if (currentChar == firstSymbol) {
                    if (findWord(j, i, new HashSet<>(), wordAsChar, 0, height, length, board)) return true;
                }
            }
        }

        return false;
    }


    private static boolean findWord(int x, int y, Set<String> visitedPairs, char[] wordAsChar, int wordPointer, int heigh, int length, char[][] matrix) {
        if (wordPointer == wordAsChar.length) return true;

        if (matrix[y][x] != wordAsChar[wordPointer]) return false;

        visitedPairs.add("" + x + y);

        int xLeft = x - 1;
        int xRight = x + 1;
        int yUp = y - 1;
        int yDown = y + 1;

        boolean first = false;
        if (xLeft > -1 && !visitedPairs.contains("" + xLeft + y)) {
            first = findWord(xLeft, y, new HashSet<>(visitedPairs), wordAsChar, wordPointer + 1, heigh, length, matrix);
        }

        boolean second = false;
        if (yUp > -1 && !visitedPairs.contains("" + x + yUp)) {
            second = findWord(x, yUp, new HashSet<>(visitedPairs), wordAsChar, wordPointer + 1, heigh, length, matrix);
        }

        boolean forth = false;
        if (yDown < heigh && !visitedPairs.contains("" + x + yDown)) {
            forth = findWord(x, yDown, new HashSet<>(visitedPairs), wordAsChar, wordPointer + 1, heigh, length, matrix);
        }

        boolean third = false;
        if (xRight < length && !visitedPairs.contains("" + xRight + y)) {
            third = findWord(xRight, y, new HashSet<>(visitedPairs), wordAsChar, wordPointer + 1, heigh, length, matrix);
        }

        return first || second || third || forth;
    }
}
