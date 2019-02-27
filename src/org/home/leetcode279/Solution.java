package org.home.leetcode279;

class Solution {
    int[] memo;
    public int numSquares(int n) {
        memo = new int[n + 1];
        return helper(n);
    }

    public int helper(int n) {
        if (n == 0)
            return 0;
        if (memo[n] != 0)
            return memo[n];
        int res = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int temp = 1 + helper(n - i * i);
            if (temp < res)
                res = temp;
        }
        memo[n] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(100));
    }
}