package com.yablokovs.leetcode.tree;

import java.util.stream.IntStream;

public class BinarySearchE704 {

    public static void main(String[] args) {

        int resp = search(IntStream.range(0, 99).toArray(), -1);

        int n = 0;
    }

    public static int search(int[] nums, int target) {
        return searchRecursive(nums, target, 0, nums.length - 1);
    }

    private static int searchRecursive(int[] nums, int target, int startIndex, int endIndex){

        int middle = (endIndex + startIndex)/2;
        if (target == nums[middle]) return middle;


        if (startIndex >= endIndex) return -1; // TODO: 4/6/23 зевнул что не == что start может стать больше конца...
        // да в случае индексов 0, 1 и таргета -1. вызовется метод с индексами 0, -1

        int result;
        if (target < nums[middle]) {
            result = searchRecursive(nums, target, startIndex, middle - 1);
        } else {
            result = searchRecursive(nums, target, middle + 1, endIndex);
        }

        return result;
    }

    public int searchCool(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }

        if (nums[l] != target) return -1;
        return l;
    }

}
