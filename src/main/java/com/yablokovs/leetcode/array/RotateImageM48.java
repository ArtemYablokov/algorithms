package com.yablokovs.leetcode.array;

/**
 * https://leetcode.com/problems/rotate-image/description/
 *
 * 1 очередность преобразования важна
 *  по-другому - можно сначала по диагонали, а потом через ГОРИЗОНТАЛЬНУЮ ОСЬ
 *
 * 2 можно реализовать перемещение одной черверти (1:1) по-штучно по кругу
 * - исключением станут вертикальные и горизонтальная оси - их так же по-штучно по-кругу переносишь
 * */


public class RotateImageM48 {
    public void rotate(int[][] matrix) {
        mirrorVerticalAxis(matrix);
        mirror2oClockAxis(matrix);

    }

    private int[][] mirrorVerticalAxis(int[][] matrix) {
        int length = matrix.length;
        int middle = length / 2;

        for (int[] raw : matrix) {
            for (int i = 0; i < middle; i++) {
                int leftElement = raw[i];

                raw[i] = raw[length - i - 1];
                raw[length - i - 1] = leftElement;
            }
        }
        return matrix;
    }

    private int[][] mirror2oClockAxis(int[][] matrix) {
        int length = matrix.length;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                int upperLeftElement = matrix[i][j];

                int oppositeJ = length - i - 1;
                int oppositeI = length - j - 1;

                matrix[i][j] = matrix[oppositeI][oppositeJ];
                matrix[oppositeI][oppositeJ] = upperLeftElement;
            }
        }

        return matrix;
    }
}
