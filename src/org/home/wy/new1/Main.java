package org.home.wy.new1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String reverse = reverse(s);
        StringBuilder res = new StringBuilder();
        String[] strings = reverse.split(" ");
        for (int i = 0; i < strings.length - 1; i++) {
            res.append(reverse2(strings[i])).append(" ");
        }
        res.append(reverse2(strings[strings.length - 1]));
        System.out.println(res.toString());
    }

    static String reverse(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            char temp = chars[j];
            chars[j] = chars[i];
            chars[i] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    static String reverse2(String s) {
        String toReverse = s;
        String f = "";
        char c = s.charAt(0);
        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
            f = c + "";
            toReverse = s.substring(1);
        }
        if (toReverse.contains("'")) {
            String[] split = toReverse.split("'");
            return f + reverse(split[0]) + "'" + reverse(split[1]);
        }
        return f + reverse(toReverse);
    }
}