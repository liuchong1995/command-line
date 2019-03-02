package org.home.search.l11;

class Solution {
    public int maxArea(int[] height) {
        int l = 0,r = height.length -1;
        int res = 0;
        while (l < r){
            int low = Math.min(height[l],height[r]);
            res = Math.max(res,low * (r-l));
            while (l < r && height[l] <= low) l++;
            while (l < r && height[r] <= low) r--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] text = {2,3,10,5,7,8,9};
        System.out.println(new Solution().maxArea(text));
    }
}