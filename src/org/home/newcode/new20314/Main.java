package org.home.newcode.new20314;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cor = new int[n][3];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < 3; j++) {
                cor[i][j] = sc.nextInt();
            }
        }
    }
}