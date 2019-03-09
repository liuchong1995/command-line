package org.home.newcode.new3;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        BigInteger win = all(m,m - n + 1).divide(all(n,1)).multiply(BigInteger.valueOf((long) Math.pow(2,(m-n))));

        System.out.println(win.remainder(BigInteger.valueOf(1000000007)));
    }

    static BigInteger all(int m,int n){
        BigInteger temp = BigInteger.valueOf(1);
        for (int i = n; i <= m; i++) {
            temp = temp.multiply(BigInteger.valueOf(i)) ;
        }
        return temp;
    }
}