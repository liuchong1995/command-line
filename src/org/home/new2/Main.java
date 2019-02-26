package org.home.new2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][4];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 4; j++){
                mat[i][j] = sc.nextInt();
            }
        }
    }

    public static String judge(int[] oneTime){
            return "NO";

    }
}