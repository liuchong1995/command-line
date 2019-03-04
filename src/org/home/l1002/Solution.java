package org.home.l1002;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] A) {
        int n = A.length;
        int[][] map = new int[n][26];
        for (int i = 0; i < A.length; i++) {
            char[] chars = A[i].toCharArray();
            for (char aChar : chars) {
                map[i][aChar - 'a']++;
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int minCount = map[0][i];
            for (int[] ints : map) {
                minCount = Math.min(ints[i],minCount);
            }
            if (minCount > 0)
                for (int j = 0; j < minCount; j++) {
                    res.add(String.valueOf((char)(i + 'a')));
                }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] a = {"bella", "label", "roller"};
        System.out.println(new Solution().commonChars(a));
    }
}