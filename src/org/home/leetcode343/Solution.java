package org.home.leetcode343;

class Solution {
    int[] memo;

    public int integerBreak(int n) {
        memo = new int[n + 1];
        return helper(n);
    }

    private int helper(int n) {
        if (n == 1)
            return   1;
        if (memo[n] != 0)
            return memo[n];
        int res = 1;
        for (int i = 1; i < n - 1; i++) {
            res = max3(res, i * (n - i), i * helper(n - i));
        }
        memo[n] = res;
        return memo[n];
    }

    int max3(int x, int y, int z) {
        return Math.max(Math.max(x, y), z);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(34));
    }
}