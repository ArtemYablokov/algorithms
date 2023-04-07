package com.yablokovs.leetcode.array;

import java.util.Arrays;

public class EFloodFill733 {

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
        int[][] visited = new int[image.length][image[0].length];
        return recursive(image, sr, sc, color, image[sr][sc], image.length, image[0].length, visited);
    }

    private static int[][] recursive(int[][] image, int sr, int sc, int color, int constantColor, int high, int width, int[][] visited) {

        printEachStep(image, sr, sc, visited);

        if (sr >=0 && sr < high && sc >=0 && sc < width && constantColor == image[sr][sc] && visited[sr][sc] != -1) {
            image[sr][sc] = color;
            visited[sr][sc] = -1;

            recursive(image, sr - 1, sc, color, constantColor, high, width, visited);
            recursive(image, sr + 1, sc, color, constantColor, high, width, visited);
            recursive(image, sr, sc - 1, color, constantColor, high, width, visited);
            recursive(image, sr, sc + 1, color, constantColor, high, width, visited);
        }
        return image;
    }

    private static void printEachStep(int[][] image, int sr, int sc, int[][] visited) {
        System.out.println("raw = " + sr);
        System.out.println("column = " + sc);

        System.out.println("Image = ");
//        System.out.println(Arrays.toString(image));
        printArray2(image);

        System.out.println("Visited = ");
//        System.out.println(Arrays.toString(visited));
        printArray2(visited);
        System.out.println();
        System.out.println();
    }

    private static void printArray2(int[][] image) {

        for (int[] ints : image) {
            System.out.println(Arrays.toString(ints));
        }

    }
}
