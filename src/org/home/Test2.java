package org.home;

/**
 * @Author: LiuChong
 * @Date: 2019-02-23 16:52
 * @Description:
 */
public class Test2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println();
        TreeNode left = root.left;
        left = null;
        System.out.println();
    }
}
