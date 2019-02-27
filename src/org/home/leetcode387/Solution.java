package org.home.leetcode387;

import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public int firstUniqChar(String s) {
        int[] fre = new int[26];
        for (char c : s.toCharArray()) {
            fre[c-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (fre[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar("cc"));
    }
}