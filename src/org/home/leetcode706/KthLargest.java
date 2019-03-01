package org.home.leetcode706;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class KthLargest {
    final PriorityQueue<Integer> q;
    final int k;

    public KthLargest(int k, int[] a) {
        this.k = k;
        q = new PriorityQueue<>(k, Comparator.naturalOrder());
        for (int n : a)
            add(n);
    }

    public int add(int n) {
        if (q.size() < k)
            q.offer(n);
        else if (q.peek() < n) {
            q.poll();
            q.offer(n);
        }
        return q.peek();
    }

    public static void main(String[] args) {
        int[] data = {10,8,1,2,3,4,5,6,7};
        KthLargest kthLargest = new KthLargest(3, data);
        System.out.println();

    }
}
