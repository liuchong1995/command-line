package org.home;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author: LiuChong
 * @Date: 2019-02-23 16:52
 * @Description:
 */
public class Test2 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(0);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(2);
//        System.out.println();
//        TreeNode left = root.left;
//        left = null;
//        System.out.println();

        List<Integer> set = new ArrayList<>();
            set.add(0);
            set.add(3);
        System.out.println( Collections.binarySearch(set,4));
    }
}
