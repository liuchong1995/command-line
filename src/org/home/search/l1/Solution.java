package org.home.search.l1;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                int[] res = {map.get(target-nums[i]),i};
                return res;
            } else
                map.put(nums[i],i);
        }
        return null;
    }
}