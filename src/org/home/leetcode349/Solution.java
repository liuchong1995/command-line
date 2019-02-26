package org.home.leetcode349;

import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        BitSet bitSet = new BitSet();
        for (int i : nums1) {
            bitSet.set(i);
        }
        Set<Integer> list = new HashSet<>();
        for (int i : nums2) {
            if(bitSet.get(i))
                list.add(i);
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            res[i++] = integer;
        }
        return res;
    }
}