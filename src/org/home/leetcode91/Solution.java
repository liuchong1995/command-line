package org.home.leetcode91;

class Solution {
    public int numDecodings(String s) {
        return 0;
    }

    public int decodings(String s) {
        if (s.length() == 0)
            return 0;
        if (s.length() == 1 && Integer.parseInt(s) != 0)
            return 1;
        if (s.length() == 1)
            return 0;
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("226"));
    }
}