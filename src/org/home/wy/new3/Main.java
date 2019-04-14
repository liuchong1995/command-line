package org.home.wy.new3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }
        Arrays.sort(weights);
        for (int i = 0; i < weights.length - 1; i++) {
            int lastBigger = 0;
            for (int j = weights.length - 1; j > i ; j--) {
                if (weights[i] + weights[j] > W) {
                    lastBigger = j;
                    continue;
                } else {
                    break;
                }
            }
            if (lastBigger != 0) {
                if (lastBigger > i+1){
                    int temp = weights[lastBigger];
                    weights[lastBigger] = weights[i + 1];
                    weights[i + 1] = temp;
                    insert(weights, i + 1,lastBigger);
                }
            }
        }
        System.out.println(count(weights,W));
    }

    private static void insert(int[] w , int first,int last) {
        int ll = last - 1;
        int temp = w[last];
        while (w[ll] > w[last] && ll > first) {
            ll--;
        }
        for (int i = last; i > ll + 1 ; i--) {
            w[i] = w[i - 1];
        }
        w[ll + 1] = temp;
    }

    private static int count(int[] w , int W) {
        int times = 1, i = 0;
        while (i < w.length - 1) {
            if (w[i] + w[i + 1] > W) {
                times++;
                i++;
            } else {
                times++;
                i+=2;
            }
        }
        return times;
    }
}