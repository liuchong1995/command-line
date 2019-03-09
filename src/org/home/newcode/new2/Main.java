package org.home.newcode.new2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] hits = new int[n];
        for (int i = 0; i < n ; i++) {
            hits[i] = in.nextInt();
        }
        System.out.println(count(hits,m));
    }

    static int count (int[] hits,int cates){
        int[] map = new int[cates + 1];
        int i = 0,j=0;
        int min = hits.length;
        for (;i < hits.length;) {
            if (hasAll(map)){
                min = Math.min(j-i,min);
                map[hits[i++]]--;
            } else {
                if (j + 1 < hits.length)
                    map[hits[j++]]++;
                else
                    i++;
            }
        }
        return min;
    }

    static boolean hasAll(int[] hits){
        for (int i = 1; i < hits.length; i++) {
            if (hits[i] < 1)
                return false;
        }
        return true;
    }
}