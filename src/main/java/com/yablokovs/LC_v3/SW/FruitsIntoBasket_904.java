package com.yablokovs.LC_v3.SW;

import com.yablokovs.LC_v3.util.Util;

public class FruitsIntoBasket_904 {

    public int totalFruitNum(int[] fruits) {
        int first = -1;
        int second = -1;
        // order of them doesn't matter
        int num1 = 0;
        int num2 = 0;

        int i = 0;
        int j = 0;
        int[] a = fruits;
        int l = a.length;
        int max = 0; // actually is a size of window
        while (j < l) {
            int cur = a[j];
            if (first == -1) {
                first = cur;
                num1++;
            } else if (second == -1) {
                second = cur;
                num2++;
            } else if (first == cur) {
                num1++;
            } else if (second == cur) {
                num2++;
            } else {
                while (num1 > 0 && num2 > 0) {
                    if (a[i] == first) {
                        num1--;
                    } else {
                        num2--;
                    }
                    i++;

                }
                if (num1 == 0) {
                    num1 = 1;
                    first = cur;
                } else { // num2 == 0
                    num2 = 1;
                    second = cur;
                }
            }
            if (max < j - i + 1)
                max = j - i + 1;
            System.out.println(Util.printSW(fruits, i, j));
            j++;
        }

        return max;
    }

    public int totalFruitIx(int[] fruits) {
        int first = -1;
        int second = -1;
        // order of them doesn't matter
        int ix1 = -1;
        int ix2 = -1;

        int i = 0;
        int j = 0;
        int[] a = fruits;
        int l = a.length;
        int max = 0; // actually is a size of window

        while (j < l) {
            int cur = a[j];
            if (first == cur || first == -1) {
                first = cur;
                ix1 = j;
            } else if (second == cur || second == -1) {
                second = cur;
                ix2 = j;
            }
            else {
                // take smaller ix of last appearance of val
                // and exclude earlier of them
                if (ix1 < ix2) {
                    i = ix1 + 1;
                    first = cur;
                    ix1 = j;
                } else {
                    i = ix2 + 1;
                    second = cur;
                    ix2 = j;
                }
            }
            if (max < j - i + 1)
                max = j - i + 1;
            System.out.println(Util.printSW(fruits, i, j));
            j++;
        }

        return max;
    }


}
