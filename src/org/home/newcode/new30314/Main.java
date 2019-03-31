package org.home.newcode.new30314;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            b[i] = sc.nextInt();
        }
        System.out.println(win_count(a,b));
    }

    static int win_count(int[] a,int[] b){
        int i = a.length-1;
        int j = i;
        Arrays.sort(a);
        Arrays.sort(b);
        int a_c = 0;
        int b_c = 0;
        boolean a_t = true;
        while (i >= 0 && j>=0){
            if (a_t){
                if (a[i] >= b[j]){
                    a_c += a[i--];
                } else {
                    j--;
                }
            } else {
                if (a[i] <= b[j]){
                    b_c += b[j--];
                } else {
                    i--;
                }
            }
            a_t = !a_t;
        }
        if (i < 0)
            while (j >= 0){
                if (a_t)
                    j--;
                else
                    b_c += b[j--];
                a_t = !a_t;
            }

        else
            while (i >= 0){
                if (a_t)
                    a_c += a[i--];
                else
                    i--;
                a_t = !a_t;
        }
        return a_c-b_c;
    }
}