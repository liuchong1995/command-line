package org.home.tc0405.tc3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] power = new long[n];
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            power[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }
        System.out.println(lessCoin(n,power,price));
    }

    static int lessCoin(int n,long[] power,int[] price) {
        boolean[] isBuy = new boolean[n];
        int[] less = new int[n];
        isBuy[0] = true;
        less[0] = price[0];
        long curPower = power[0];
        for (int i = 1; i < n; i++) {
            if (curPower > power[i]) {
                less[i] = less[i - 1];
            } else {
                if (price[i] == 1) {
                    int noBuyMaxP1 = -1;
                    long noBuyMaxP1P = -1;
                    for (int j = 0; j < i; j++) {
                        if (!isBuy[j] && power[j] > noBuyMaxP1P && price[j] == 1) {
                            noBuyMaxP1 = j;
                            noBuyMaxP1P = power[j];
                        }
                    }
                    if (noBuyMaxP1 == -1 || noBuyMaxP1P < power[i] || curPower + noBuyMaxP1P < power[i]) {
                        isBuy[i] = true;
                        less[i] = less[i - 1] + price[i];
                        curPower = curPower + power[i];
                    } else {
                        isBuy[noBuyMaxP1] = true;
                        less[i] = less[i - 1] + price[noBuyMaxP1];
                        curPower = curPower + power[noBuyMaxP1];
                    }
                } else {
                    int noBuyMaxP1 = -1;
                    int noBuyMaxP2 = -1;
                    long noBuyMaxP1P = -1;
                    long noBuyMaxP2P = -1;
                    for (int j = 0; j < i; j++) {
                        if (!isBuy[j] && power[j] > noBuyMaxP1P && price[j] == 1) {
                            noBuyMaxP1 = j;
                            noBuyMaxP1P = power[j];
                        } else if (!isBuy[j] && power[j] > noBuyMaxP2P && price[j] == 2) {
                            noBuyMaxP2 = j;
                            noBuyMaxP2P = power[j];
                        }
                    }
                    if (noBuyMaxP1 == -1 && noBuyMaxP2 == -1) {
                        isBuy[i] = true;
                        less[i] = less[i - 1] + price[i];
                        curPower = curPower + power[i];
                        continue;
                    }
                    if (curPower + noBuyMaxP1P < power[i]) {
                        isBuy[i] = true;
                        less[i] = less[i - 1] + price[i];
                        curPower = curPower + power[i];
                        continue;
                    } else if (curPower + noBuyMaxP1P >= power[i]){
                        isBuy[noBuyMaxP1] = true;
                        less[i] = less[i - 1] + price[noBuyMaxP1];
                        curPower = curPower + power[noBuyMaxP1];
                        continue;
                    }
                    if (curPower + noBuyMaxP2P < power[i]) {
                        isBuy[i] = true;
                        less[i] = less[i - 1] + price[i];
                        curPower = curPower + power[i];
                        continue;
                    } else if (noBuyMaxP2P >= power[i]) {
                        isBuy[noBuyMaxP2] = true;
                        less[i] = less[i - 1] + price[noBuyMaxP2];
                        curPower = curPower + power[noBuyMaxP2];
                        continue;
                    } else if (noBuyMaxP2P < power[i]) {
                        isBuy[i] = true;
                        less[i] = less[i - 1] + price[i];
                        curPower = curPower + power[i];
                        continue;
                    }
                }
            }
        }
        return less[n-1];
    }
}