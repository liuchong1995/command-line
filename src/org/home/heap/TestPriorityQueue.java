package org.home.heap;

import org.home.Student;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @Author: LiuChong
 * @Date: 2019-03-03 20:17
 * @Description:
 */
@SuppressWarnings("Duplicates")
public class TestPriorityQueue {

    public static void main(String[] args) {

        //默认不传比较参数是一个小顶堆
        //PriorityQueue<Integer> q1 = new PriorityQueue<>();
        //传一个自然顺序比较器也是小顶堆
        //PriorityQueue<Integer> q1 = new PriorityQueue<>(Comparator.naturalOrder());
        //传一个反向顺序比较器是大顶堆
        //PriorityQueue<Integer> q1 = new PriorityQueue<>(Comparator.reverseOrder());

        //传一个lamda 默认也是从小到大
        //PriorityQueue<Integer> q1 = new PriorityQueue<>((o1,o2) -> o1.compareTo(o2));
        //传一个lamda 反向
        //PriorityQueue<Integer> q1 = new PriorityQueue<>((o1,o2) -> o2.compareTo(o1));

        PriorityQueue<Student> q1 = new PriorityQueue<>((o1,o2) -> o2.getGrade() - o1.getGrade());

        Random random = new Random(666);
        for (int i = 0; i < 10; i++) {
            int anInt = random.nextInt(100);
            q1.add(new Student(anInt));
            System.out.print(anInt + "  ");
        }
        System.out.println();
        while (!q1.isEmpty())
            System.out.print(q1.poll() + "  ");
    }
}
