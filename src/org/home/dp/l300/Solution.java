package org.home.dp.l300;

class Solution {

    private int[] memo;
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        memo = new int[nums.length - 1];
        int res = 1;
        for(int i = 0 ; i < nums.length ; i ++)
            res = Math.max(res, getMaxIndex(nums, i));
        return memo[nums.length - 1];
    }


    private int getMaxIndex(int[] nums, int i){

        if (i == 0)
            return 1;
        if (memo[i] != 0)
            return memo[i];
        int ret = 1;
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j])
                ret = Math.max(ret,1+getMaxIndex(nums,j));
        }
        memo[i] = ret;
        return ret;
    }
}