package org.home.pddexam.pdd3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dis = sc.nextInt();
        TreeSet<Bank> banks = new TreeSet<>((o1, o2) -> {
            if (o1.val != o2.val)
                return o2.val - o1.val;
            return o1.pos - o2.pos;
        });
        for (int i = 0; i < n; i++) {
            banks.add(new Bank(sc.nextInt(),sc.nextInt()));
        }
        List<Bank> list = new ArrayList<>();
        list.add(banks.pollFirst());
        Bank bank1 = banks.pollFirst();
        while (Math.abs(bank1.pos-list.get(0).pos) < dis){
            list.add(bank1);
            bank1 = banks.pollFirst();
        }
        list.add(bank1);
        int ret = list.get(0).val + list.get(list.size() - 1).val;
        for (int i = 1; i < list.size() - 2; i++) {
            for (int j = i+1; j < list.size() - 2; j++) {
                if (Math.abs(list.get(i).pos - list.get(j).pos) >= dis)
                    ret = Math.max(ret,list.get(i).val + list.get(j).val);
            }
        }
        System.out.println(ret);

    }
    static class Bank{
        int pos;
        int val;
        public Bank(int pos, int val) {
            this.pos = pos;
            this.val = val;
        }
    }
}

