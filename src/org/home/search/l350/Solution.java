package org.home.search.l350;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> n1 = new HashMap<>();
        for (int i : nums1) {
            n1.put(i,n1.getOrDefault(i,0) + 1);
        }
        List<Integer> temp = new ArrayList<>();
        for (int i : nums2) {
            Integer count = n1.getOrDefault(i, 0);
            if (count > 0){
                temp.add(i);
                n1.put(i,--count);
            }
        }
        int[] res = new int[temp.size()];
        int i = 0;
        for (Integer integer : temp) {
            res[i++] = integer;
        }
        return res;
    }
}