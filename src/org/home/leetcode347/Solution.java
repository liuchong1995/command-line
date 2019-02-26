package org.home.leetcode347;

import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num,map.get(num) + 1);
            else
                map.put(num,1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry);
            if (queue.size() > k)
                queue.poll();
        }
        LinkedList<Integer> res = new LinkedList<>();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            res.addFirst(queue.poll().getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {1,1,1,2,2,3};
        new Solution().topKFrequent(test,2);
        System.out.println();
    }
}