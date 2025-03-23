package com.yablokovs.LC_v3.util;

import java.util.Arrays;
import java.util.Map;

public class Util {
    public static int[] build(int... arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    public static StringBuilder printSW(int[] a, int i, int j) {
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < a.length; k++) {
            if (i == k) {
                sb.append('|');
            }
            sb.append(" ").append(a[k]).append(" ");
            if (j == k) {
                sb.append('|');
            }
        }
        return sb;
    }

    public static <E, V> void printMap(Map<E, V> map) {
        System.out.println("Map entries:");
        for (Map.Entry<E, V> entry : map.entrySet()) {
            System.out.println(entry.getKey().toString() + " - " + entry.getValue().toString());
        }
    }
}
