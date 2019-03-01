package org.home;

/**
 * @Author: LiuChong
 * @Date: 2019-03-01 13:02
 * @Description:
 */
public class JDKTest {

    public static void main(String[] args) {
        Integer x = new Integer(123);
        Integer y = new Integer(123);
        System.out.println(x == y);    // false
        Integer z = Integer.valueOf(123);
        Integer k = Integer.valueOf(123);
        System.out.println(z == k);   // true

    }
}
