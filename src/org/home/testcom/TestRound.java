package org.home.testcom;

import org.junit.Test;

/**
 * @Author: LiuChong
 * @Date: 2019-04-07 23:18
 * @Description:
 */
public class TestRound {
    public static void main(String[] args) {
        double a = 3.5;
        System.out.println(Math.round(a));
    }

    @Test
    public void t1() {
        // &  | 优先级低于 ==
        System.out.println((1|1) == 0);
    }
}
