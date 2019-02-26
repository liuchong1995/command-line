package org.home.leetcode76;

class Solution {
    public String minWindow(String s, String t) {
        int l = 0;
        int r = -1;
        String res = "";
        int[] freq = new int[256];
        while (l < s.length()){
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0){
                freq[s.charAt(++r)]++;
            } else {
                freq[s.charAt(l++)]--;
            }
            boolean isContain = true;
            for (char c : t.toCharArray()) {
                if (freq[c] == 0){
                    isContain = false;
                    break;
                }
            }
            if (isContain){
                if (r - l + 1 < res.length() || res.length() == 0)
                    res = s.substring(l,r+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = new Solution().minWindow("ADOBECODEBANC", "ABC");
        System.out.println();
    }
}