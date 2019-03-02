package org.home.pat;

import java.util.Scanner;

/**
 * @Author: LiuChong
 * @Date: 2019-03-02 15:10
 * @Description:
 */
public class t1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = scanner.nextInt();
        for (int i = 1; i < caseCount + 1; i++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long c = scanner.nextLong();
            System.out.println(String.format("Case #%d: %s",i,big(a,b,c)));
        }
    }

    public static boolean big(long a, long b,long c){
        return a + b > c;
    }
}
