package org.home.leetcode80;

import java.util.Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {

        int i = 0;
        int j = 0;
        while(j < nums.length){
            int k = nextIndex(nums, j);
            int len = Math.min( 2, k-j);
            for(int ii = 0 ; ii < len ; ii ++)
                nums[i+ii] = nums[j];
            i += len;
            j = k;
        }

        return i;
    }

    int nextIndex(int[] nums, int index){
        for(int i = index ; i < nums.length ; i ++)
            if(nums[i] != nums[index])
                return i;
        return nums.length;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,1,2,3,3};
        new Solution().removeDuplicates(arr);
        System.out.println();
    }
}