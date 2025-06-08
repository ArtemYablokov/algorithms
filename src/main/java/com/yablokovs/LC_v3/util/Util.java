package com.yablokovs.LC_v3.util;

import java.util.Arrays;
import java.util.Map;

public class Util {
    public static int[] build(int... arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    // [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
    public static int[][] build2d(String arrays) {
        String[] split = getSubStrings(arrays);

        int[][] result = new int[split.length][];

        for (int i = 0; i < result.length; i++) {
            String cur = split[i]; // 0,6,7
            String[] subStrings = cur.split(",");
            int[] t = new int[subStrings.length];
            for (int j = 0; j < t.length; j++) {
                t[j] = Integer.parseInt(subStrings[j]);
            }
            result[i] = t;
        }

        return result;
    }

    private static String[] getSubStrings(String arrays) {
        StringBuilder sb = new StringBuilder(arrays);
        sb.deleteCharAt(0);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        String s = sb.toString();
        return s.split("\\],\\[");
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
