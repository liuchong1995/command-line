package org.home.search.l447;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> distMap = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int dist = dist(points[i],points[j]);
                    distMap.put(dist,distMap.getOrDefault(dist,0) + 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : distMap.entrySet()) {
               if (entry.getValue() > 1)
                   res += entry.getValue() *(entry.getValue()-1);
            }
        }
        return res;
    }

    public int dist(int[] p1, int[] p2) {
        return (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
    }
}