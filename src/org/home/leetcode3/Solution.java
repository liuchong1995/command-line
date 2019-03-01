package org.home.leetcode3;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int l = 0,r=-1;
        int res = 0;
        for (; l < s.length();) {
            if (r + 1 < s.length()){
                if (freq[s.charAt(++r)] == 0){
                    freq[s.charAt(r)]++;
                    res = Math.max(res,r-l + 1);
                }
                else
                    freq[s.charAt(l++)]--;
            } else
                l++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("  a"));
    }
}