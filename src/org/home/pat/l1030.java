package org.home.pat;

import java.util.*;

/**
 * @Author: LiuChong
 * @Date: 2019-03-02 15:19
 * @Description:
 */
public class l1030 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        //char[] s = new char[5000];
        //char[] pat = {'P','A','T'};
        //for (int i = 0; i < s.length; i++) {
        //    s[i] = pat[i%3];
        //}
        System.out.println(countPAT(new String(s)));

    }
    public static int countPAT(String s){
        List<Integer> setT = new ArrayList<>();
        List<Integer> setA = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'T')
                setT.add(i);
            else if (s.charAt(i) == 'A')
                setA.add(i);
        }
        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'P'){
                int j = Collections.binarySearch(setA,i);
                int k = Collections.binarySearch(setT,setA.get(-j - 1));
                res += (setA.size() + j + 1) * (setT.size() + k + 1);
            }
        }
        return (int) (res % 1000000007);
    }
}
