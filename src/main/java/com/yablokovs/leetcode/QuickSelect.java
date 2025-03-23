package com.yablokovs.leetcode;

public class QuickSelect {
    int l;

    public int findKthLargest(int[] nums, int k) {
        l = nums.length;
        k = l - k;

        partition(nums, 0, l - 1, k);
        return nums[k];
    }

    private void partition(int[] nums, int i, int j, int k) {
        int pivot = nums[i];
        int s = i;
        int e = j;
        i++;
        while (i <= j) {
            while (i <= j && nums[i] < pivot)
                i++;
            while (j >= i && nums[j] > pivot)
                j--;

            if(i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, s, j);

        if (j == k)
            return;
        if (j > k)
            partition(nums, s, j - 1, k);
        else
            partition(nums, j + 1, e, k);

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
