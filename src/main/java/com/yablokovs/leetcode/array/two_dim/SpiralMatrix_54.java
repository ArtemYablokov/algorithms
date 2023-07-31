package com.yablokovs.leetcode.array.two_dim;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length;
        int up = 0;
        int down = matrix.length;
        List<Integer> result = new ArrayList<>();

        while(left < right && up < down) {
            // forward
            for(int  i = left; i < right; i++) {
                result.add(matrix[up][i]);
            }
            up++;
            // down
            for(int i = up; i < down; i++) {
                result.add(matrix[i][right - 1]);
            }
            right--;

            if (up < down && left < right) {
                // left
                for(int i = right - 1; i >= left; i--) {
                    result.add(matrix[down - 1][i]);
                }
                down--;

                // up
                for(int i = down - 1; i >= up; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
