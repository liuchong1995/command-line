package org.home.tc0405.tc2;// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(lastNum(str));
    }

    static int lastNum(String s) {
        int[] map = new int[2];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            map[aChar - '0']++;
        }
        return Math.abs(map[0] - map[1]);
    }
}