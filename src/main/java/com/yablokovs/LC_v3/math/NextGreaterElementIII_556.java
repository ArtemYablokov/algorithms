package com.yablokovs.LC_v3.math;

public class NextGreaterElementIII_556 {
    public int nextGreaterElement(int n) {

        int l = Integer.toString(n).length();
        int[] num = new int[l];
        //123

        for (int i = 0; i < l; i++) {
            num[i] = n % 10;
            n /= 10;
        }
        // IntStream.range(0, 10).forEach(i -> {
        //     num[i] = n % 10;
        //     n /= 10;
        // });
        // 3 2 1


        int ix = 0;
        while (ix < l - 1) {
            if (num[ix] > num[ix + 1]) break;
            ix++;
        }
        if (ix == l - 1) return -1;
        System.out.println(ix);
        int j = 0;
        while (j < ix) {
            if (num[j] > num[ix + 1]) break;
            j++;
        }
        System.out.println(j);

        swap(ix + 1, j, num);


        for (int i = 0; i <= (ix / 2); i++) {
            swap(ix - i, i, num);
        }
        // 2 147 483 486 -> 648

        // 2 147 483 647
        // int check = Integer.MAX_VALUE / 10;
        int[] check = new int[10];
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            check[i] = max % 10;
            max /= 10;
        }
        if(l == 10) {
            for (int i = l - 1; i >= 0; i--) {
                if (num[i] < check[i]) break;
                if (num[i] > check[i]) return -1;
            }
        }



        int result = 0;
        for (int i = l - 1; i >= 0; i--) {
            result *= 10;
            result += num[i];
        }

        return result;
    }

    void swap(int i, int j, int[] num) {
        // System.out.printf("swap %d %d", i, j);
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
    }

}
