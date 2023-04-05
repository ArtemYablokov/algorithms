package com.yablokovs.atlassian;

public class CountOnesInBinaryRepresentation {

    public static void main(String[] args) {


        System.out.println(countOleg(7, 3));

//        int num = (int) 4.1D;
//        System.out.println(num);
//
//        System.out.println(binaryRightWhile(-3, 7));
//
//        long minus21 = -21;
//
//        System.out.println(">> с сохранением знака = арифметическое");
//        long res = minus21;
//        for (int i = 0; i < 100; i++) {
//            System.out.println("toBinaryString: " + res + " = " + Long.toBinaryString(res));
//            System.out.println("toString: " + res + " = " + Long.toString(res, 2));
//            res >>= 1;
//        }
//
//        System.out.println(">>> без сохранения знака = логическое");
//        res = minus21;
//        for (int i = 0; i < 100; i++) {
//            System.out.println("toBinaryString: " + res + " = " + Long.toBinaryString(res));
//            System.out.println("toString: " + res + " = " + Long.toString(res, 2));
//            res >>>= 1;
//        }
    }


    private static int binaryLeft(int A, int B) {
        int res = 0;
        long product = (long) A * B;

        for (int i = 0; i < 64; i++) {
            if ((product & (1L << i)) > 0) {
                res++;
            }
        }

        return res;
    }


    private static int binaryRight(int A, int B) {
        int res = 0;
        long product = (long) A * B;

        for (int i = 0; i < 64; i++) {
            if (((product >> i) & 1) == 1) {
                res++;
            }
        }

        return res;
    }

    private static int binaryRightWhile(int A, int B) {
        long product = (long) A * B;

        int res = 0;
        while (product > 0) {
            if ((product & 1) == 1) {
                res++;
            }
            product >>= 1; // >>>
        }
        return res;
    }


    public static int countOleg(int a, int b) {

        boolean nonStop = true;
//        int a = 99, b = 28;
        int count = 0;
        int r = a * b;

        while (nonStop) {
//            System.out.println("Bit representative of number: " + (Integer.toBinaryString(r)));
//            System.out.println("R: " + (r));
//            System.out.println("(r & 1): " + (r & 1));

            if ((r & 1) == 1) {
                count++;
            }
            r >>>= 1;
            if (r == 0) {
                nonStop = false;
            }
        }
        return count;


    }
}
