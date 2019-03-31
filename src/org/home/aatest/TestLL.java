package org.home.aatest;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * @Author: LiuChong
 * @Date: 2019-03-17 21:42
 * @Description:
 */
public class TestLL {

    private static Random r = new Random(666);

    @Test
    public void tLL() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.add(r.nextInt(25));
        }
        for (Integer integer : linkedList) {
            System.out.println(integer);
        }
        Iterator<Integer> iterator = linkedList.descendingIterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

}
