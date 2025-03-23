package com.yablokovs.leetcode.v2.stack;

public class DecodeString_394 {
    public String decodeString(String s) {

        return build(0, s.length() - 1, s.toCharArray()).toString();
    }

// idea - return only end index of builded String
// and add String directly to passed target
// NOPE - since we can't append linearly strings - there is multupliers

    private StringBuilder build(int i, int j, char[] arr) {

        StringBuilder local = new StringBuilder();
        while (i <= j) {
            while (i <= j && arr[i] >= 'a' && arr[i] <= 'z') {
                local.append(arr[i]);
                i++;
                continue;
            }
            if (i > j) return local;
            // else - digit
            StringBuilder digit = new StringBuilder();
            while (arr[i] >= '0' && arr[i] <= '9') {
                digit.append(arr[i++]);
            }
            // i == [
            int start = i + 1; // move inside bracket
            int end = start;

            while (arr[end] != ']')
                end++;
            StringBuilder inner = build(start, end - 1, arr);
            System.out.println(inner.toString());
            for (int k = 0; k < Integer.parseInt(digit.toString()); k++)
                local.append(inner);
            // end == ]
            i = end + 1;
        }

        return local;
    }

}
