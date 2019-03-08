package org.home;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: LiuChong
 * @Date: 2019-03-07 10:56
 * @Description:
 */
public class Test111 {


    public static void main(String[] args) {
        Random random = new Random(666);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add(random.nextInt(1000000000));
        }
        long s = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            for (Integer integer : list) {
                if (integer % 2 == 1) {

                }

            }
        }

        long e = System.currentTimeMillis();
        System.out.println(e-s);
        s = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            for (Integer integer : list) {
                if ((integer & 1) == 1) {

                }

            }
        }

        e = System.currentTimeMillis();
        System.out.println(e-s);
    }



}
