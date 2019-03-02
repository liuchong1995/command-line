package org.home.search.l220;

import java.util.TreeSet;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> containNums = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (containNums.floor(((long)nums[i] + t)) != null && containNums.floor (((long)nums[i] + t)) >= (long)nums[i] - t) {
                return true;
            }
            containNums.add((long) nums[i]);
            if (containNums.size() > k)
                containNums.remove((long)nums[i-k]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 9, 1, 5, 9};
        int k = 2;
        int t = 3;
        System.out.println(new Solution().containsNearbyAlmostDuplicate(nums,k,t));
    }
}