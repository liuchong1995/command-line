package org.home.new1;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = 0;
        int f = 0;
        int d = 0;
        int p = 0;
        x = in.nextInt();
        f = in.nextInt();
        d = in.nextInt();
        p = in.nextInt();
        if(d/x < f)
            System.out.println(d/x);
        while (d/x > f){
            d -= p;
            f++;
        }
        System.out.println(f - 1);
    }
}