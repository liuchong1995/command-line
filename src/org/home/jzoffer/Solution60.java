package org.home.jzoffer;

/**
 * @Author: LiuChong
 * @Date: 2019-03-04 14:12
 * @Description:
 */
public class Solution60 {
    static int[] memo;

    static int count(int n) {
        int res = 0;
        if (n == 1) {
            res = 1;
            return res;
        }
        if (memo[n] != 0)
            return memo[n];
        for (int i = 1; i < 7; i++) {
            res += n - i <= 0 ? 0 : count(n - i);
        }
        memo[n] = res + 1;
        return res + 1;
    }

    public static void main(String[] args) {
        int n = 100;
        memo = new int[n + 1];
        System.out.println(count(3));
    }
}
