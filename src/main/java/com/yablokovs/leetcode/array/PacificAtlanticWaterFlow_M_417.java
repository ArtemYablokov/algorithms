package com.yablokovs.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow_M_417 {


    public static void main(String[] args) {
        int[][] heights = new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
    }


    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int length = heights.length;
        int height = heights[0].length;

        int[][] pacific = initPacific(heights, length, height);
        int[][] atlantic = initAtlantic(heights, length, height);

        markPacific(pacific, length, height, heights);
        markAtlantic(atlantic, length, height, heights);

        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                if (atlantic[i][j] == 1 && pacific[i][j] == 1)
                    answer.add(new ArrayList<>(Arrays.asList(i, j)));
            }
        }
        return answer;
    }


    private void markPacific(int[][] pacific, int length, int height, int[][] heights) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                if (checkNear(i, j, height, length, pacific, heights))
                    pacific[i][j] = 1;
            }
        }
    }

    private void markAtlantic(int[][] atlantic, int length, int height, int[][] heights) {
        for (int i = length - 1; i > -1; i--) {
            for (int j = length - 1; j > -1; j--) {
                if (checkNear(i, j, height, length, atlantic, heights))
                    atlantic[i][j] = 1;
            }
        }
    }


    private boolean checkNear(int i, int j, int length, int height, int[][] anyMatrix, int[][] heights) {
        int iLeft = i - 1;
        int iRight = i + 1;
        int jUp = j - 1;
        int jDown = j + 1;

        boolean left = iLeft >= 0 && anyMatrix[iLeft][j] == 1 && heights[iLeft][j] <= heights[i][j];
        boolean right = iRight < length && anyMatrix[iRight][j] == 1 && heights[iRight][j] <= heights[i][j];
        boolean up = jUp >= 0 && anyMatrix[i][jUp] == 1 && heights[i][jUp] <= heights[i][j];
        boolean down = jDown < height && anyMatrix[i][jDown] == 1 && heights[i][jDown] <= heights[i][j];

        return left || right || up || down;
    }


    // право низ
    private int[][] initAtlantic(int[][] heights, int length, int height) {
        int[][] atlantic = new int[length][height];

        // низ
        for (int i = 0; i < height; i++) {
            atlantic[length - 1][i] = 1;
        }
        // право
        for (int i = 0; i < length; i++) {
            atlantic[i][height - 1] = 1;
        }
        return atlantic;
    }


    // лево верх
    private int[][] initPacific(int[][] heights, int length, int height) {
        int[][] pacific = new int[length][height];

        // верх
        for (int i = 0; i < height; i++) {
            pacific[0][i] = 1;
        }
        // лево
        for (int i = 0; i <  length; i++) {
            pacific[i][0] = 1;
        }
        return pacific;
    }
}
