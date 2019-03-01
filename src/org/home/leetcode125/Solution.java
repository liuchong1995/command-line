package org.home.leetcode125;

class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(isAlp(s.charAt(l))&&isAlp(s.charAt(r))){
                if(isSame(s.charAt(l),s.charAt(r))){
                    l++;
                    r--;
                } else{
                   return false;
                }
            } else if(isAlp(s.charAt(l))&&!isAlp(s.charAt(r))){
                r--;
            } else if(!isAlp(s.charAt(l))&&isAlp(s.charAt(r))){
                l++;
            } else{
                 l++;
                 r--;
            }
            
        }
                 return true;
    }
          
    public boolean isAlp(char c){
        return (c - 'a' < 26 && c - 'a' >=0) || (c - 'A' < 26 && c - 'A' >= 0) || (c - '0' < 10 && c - '0' >=0);
    }
    
    public boolean isSame(char a,char b){
        if (a - '0' < 10 && a - '0' >=0 || b - '0' < 10 && b - '0' >=0)
            return Math.abs(a - b) == 0;
        return Math.abs(a - b) == 0 || Math.abs(a - b) == 32;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("0P"));
    }
}