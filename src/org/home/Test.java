package org.home;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] array = generateArray(200, 0, 1000);
        int kthLargest = findKthLargest(array, 50);
        int kthLargest2 = findKthLargest2(array, 50);
        System.out.println();
    }

    public static int findKthLargest(int[] nums, int k) {
        k = nums.length - k + 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 大顶堆
        return maintainHeapSize(nums, k, pq);
    }

    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 小顶堆
        return maintainHeapSize(nums, k, pq);
    }

    private static int maintainHeapSize(int[] nums, int k, PriorityQueue<Integer> pq) {
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k)  // 维护堆的大小为 K
                pq.poll();
        }
        return pq.peek();
    }

    public static int[] generateArray(int size,int start,int bound){
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(bound) + start;
        }
        return arr;
    }
}
