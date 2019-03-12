package org.home.pat;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Author: LiuChong
 * @Date: 2019-03-02 15:19
 * @Description:
 */
public class l1030 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] chars = s.toCharArray();
        BigInteger p = BigInteger.valueOf(0), a = BigInteger.valueOf(0), t = BigInteger.valueOf(0);
        for (char c : chars) {
            if (c == 'P')
                p = p.add(BigInteger.valueOf(1));
            else if (c == 'A')
                a = a.add(p);
            else
                t = t.add(a);
        }
        System.out.println(t.remainder(BigInteger.valueOf(1000000007)));
    }
}
