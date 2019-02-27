package org.home.leetcode120;

import java.util.List;

class Solution {
    int[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        memo = new int[triangle.size()][triangle.size()];
        return minimumTotal(triangle, 0, 0);
    }

    public int minimumTotal(List<List<Integer>> triangle,int lev, int pos) {
        if (lev == triangle.size())
            return 0;
        if (memo[lev] [pos] == 0)
            memo[lev] [pos] = Math.min(minimumTotal(triangle,lev + 1,pos),minimumTotal(triangle,lev + 1,pos + 1));
        return triangle.get(lev).get(pos) + memo[lev] [pos];
    }
}