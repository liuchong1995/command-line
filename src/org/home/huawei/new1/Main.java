package org.home.huawei.new1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static char add = '+';
    private static char sub = '-';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(cal(s));
    }

    private static int cal(String s) {
        List<Integer> nums = new ArrayList<>();
        List<Integer> mut = new ArrayList<>();
        int i = 0, j = 0;
        while (j < s.length()){
            if (s.charAt(j) == add){
                mut.add(1);
                nums.add(Integer.parseInt(s.substring(i, j)));
                j++;
                i = j;
            } else if (s.charAt(j) == sub){
                mut.add(0);
                nums.add(Integer.parseInt(s.substring(i, j)));
                j++;
                i = j;
            } else {
                j++;
            }
        }
        nums.add(Integer.parseInt(s.substring(i)));
        int temp = nums.get(0);
        for (int k = 1; k < nums.size(); k++) {
            if (mut.get(k-1) == 1)
                temp += nums.get(k);
            else
                temp -= nums.get(k);
        }
        return temp;
    }
}