package org.home.tc0405.tc1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] denomination = new int[n + 2];
        for (int i = 1; i < n + 1; i++) {
            denomination[i] = sc.nextInt();
        }
        Arrays.sort(denomination, 1, n);
        if (denomination[1] != 1) {
            System.out.println("-1");
            return;
        }
        int curMax = 1;
        int ans = 1;
        for (int i = 2; i <= n + 1 && denomination[i] <= m + 1; i++) {   //注意有可能出现M比某种硬币的面值更小
            if (denomination[i] - 1 <= curMax) continue;
            int t = (int) Math.ceil(1.0 * (denomination[i] - 1 - curMax) / (denomination[i - 1]));//向上取整，因为如果无法恰好凑成就多用一个
            ans += t;
            curMax += denomination[i - 1] * t;
        }
        System.out.println(ans);
    }
}