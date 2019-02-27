package org.home.leetcode64;


class Solution {
    int[][] memo;

    public int minPathSum(int[][] grid) {
        memo = new int[grid.length + 1][grid[0].length+1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        return minPathSum(grid, 0, 0);
    }

    public int minPathSum(int[][] grid, int i, int j) {
        if (i == grid.length || j == grid[0].length)
            memo[i][j] = Integer.MAX_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1)
            memo[i][j] = grid[i][j];
        if (memo[i][j] == 0)
            memo[i][j] = grid[i][j] + Math.min(minPathSum(grid,i+1,j),minPathSum(grid,i,j+1));
        return memo[i][j];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Solution().minPathSum(grid));
    }
}