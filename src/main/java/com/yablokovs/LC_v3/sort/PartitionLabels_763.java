package com.yablokovs.LC_v3.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionLabels_763 { //

    public static List<Integer> partitionLabels(String s) {
        int[][] a = new int[26][];
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            int c = ch[i] - 'a';
            if (a[c] == null) { // first appearance
                a[c] = new int[]{i, i};
            } else { // update end
                a[c][1] = i;
            }
        }

        Arrays.sort(a, (x, y) -> {
            if (x == null && y == null) {
                return 0;
            } else if (x == null) {
                return 1;
            } else if (y == null) {
                return -1;
            }
            return Integer.compare(x[0], y[0]);
        }); //sort by start


        List<Integer> result = new ArrayList<>();
        int start = 0;
        int i = 0;

        while (i < 26 && a[i] != null) {
            int curEnd = a[i][1];
            i++;
            while (i < 26 && a[i] != null && a[i][0] < curEnd) {
                if (curEnd < a[i][1]) {
                    curEnd = a[i][1];
                }
                i++;
            }
            result.add(curEnd - start + 1);
            start = curEnd + 1;
        }


        return result;
    }

    public static void main(String[] args) {
//        List<Integer> s1 = PartitionLabels_763.partitionLabels("ababcbacadefegdehijhklij");
//        List<Integer> s2 = PartitionLabels_763.partitionLabels("abczce");
        List<Integer> s3 = PartitionLabels_763.partitionLabels("aza");
    }
}
