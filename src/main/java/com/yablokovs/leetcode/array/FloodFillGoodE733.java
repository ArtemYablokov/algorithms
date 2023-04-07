package com.yablokovs.leetcode.array;

import java.util.Arrays;

/**
* Visited matrix not required because if color in matrix and new color are the same -> nothing need to be done.
* */


public class FloodFillGoodE733 {

    public static void main(String[] args) {

        int[][] matrix = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] matrix0= {{0,0,0},{0,0,0},{0,0,0}};
        int[][] matrix2= {{0,0,0},{0,0,0}};


//        int[][] ints = floodFill(matrix, 1, 1, 2);
//        int[][] ints0 = floodFill(matrix0, 0, 0, 0);
        int[][] ints2 = floodFill(matrix2, 1, 0, 2);

        int n = 0;
    }


    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int currentColor = image[sr][sc];
        if (currentColor == color) return image;

        return recursive(image, sr, sc, color, currentColor, image.length, image[0].length);
    }

    private static int[][] recursive(int[][] image, int sr, int sc, int color, int currentColor, int high, int width) {

        printEachStep(image, sr, sc);

        if (sr >=0 && sr < high && sc >=0 && sc < width && currentColor == image[sr][sc]) {
            image[sr][sc] = color;

            recursive(image, sr - 1, sc, color, currentColor, high, width);
            recursive(image, sr + 1, sc, color, currentColor, high, width);
            recursive(image, sr, sc - 1, color, currentColor, high, width);
            recursive(image, sr, sc + 1, color, currentColor, high, width);
        }
        return image;
    }

    private static void printEachStep(int[][] image, int sr, int sc) {
        System.out.println("raw = " + sr);
        System.out.println("column = " + sc);

        System.out.println("Image = ");
//        System.out.println(Arrays.toString(image));
        printArray2(image);

        System.out.println();
        System.out.println();
    }

    private static void printArray2(int[][] image) {

        for (int[] ints : image) {
            System.out.println(Arrays.toString(ints));
        }

    }
}
