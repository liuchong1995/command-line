package org.home.leetcode215;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] arr, int l, int h) {
        int i = l + 1, j = h;
        while (true) {
            while (arr[i] < arr[l] && i <= h) i++;
            while (arr[j] > arr[l] && j >= l+1) j--;
            if (i >= j)
                break;
            swap(arr, i, j);
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}