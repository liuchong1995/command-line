package org.home.dp.l322;

import java.util.Arrays;

class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount+1];
        Arrays.fill(memo, Short.MAX_VALUE);
        Arrays.sort(coins);
        coin(coins, amount);
        return memo[amount] >= Short.MAX_VALUE ? -1 : memo[amount];
    }


    public int coin(int[] coins, int amount) {
        if (amount == 0){
            memo[0] = 0;
            return 0;
        }
        if (amount < coins[0])
            return Short.MAX_VALUE;
        if (memo[amount] != Short.MAX_VALUE)
            return memo[amount];
        int res = 1 + coin(coins,amount-coins[0]);
        for (int i = 1; i < coins.length; i++) {
            res = Math.min(res,1 + coin(coins,amount-coins[i]));
        }
        memo[amount] = res;
        return memo[amount];
    }

    public static void main(String[] args) {
        int [] coins = {1};
        int res = new Solution().coinChange(coins, 0);
        System.out.println(res);
    }
}