package org.home.heap;

import java.util.Random;

/**
 * @Author: LiuChong
 * @Date: 2019-03-03 14:56
 * @Description:
 */
public class MaxHeap<Item extends Comparable> {

    private Item[] data;
    private int count;
    private int capacity;

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public MaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        count = 0;
        capacity = capacity;
    }

    // 返回堆中的元素个数
    public int size() {
        return count;
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    public void add(Item item) {
        data[++count] = item;
        shiftUp(count);
    }

    public Item poll(){
        if (isEmpty())
            return null;
        Item res = data[1];
        swap(1,count--);
        shiftDown(1);
        return res;
    }



    private void shiftUp(int k) {
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }


    private void shiftDown(int k){
        while (2*k <= count){
            int j = 2*k;
            if (j+1 <= count && data[j].compareTo(data[j+1]) < 0)
                j++;
            if (data[k].compareTo(data[j]) >= 0)
                break;
            swap(k,j);
            k = j;
        }
    }


    private void swap(int i, int j) {
        Item temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    // 测试 MaxHeap
    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(20);
        Random random = new Random(777);
        for (int i = 0; i < 20; i++) {
            maxHeap.add(random.nextInt(1000));
        }
        for (int i = 0; i < 20; i++) {
            System.out.print(maxHeap.poll() + " => ");
        }
        System.out.println("null");
    }

}
