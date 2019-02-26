package org.home.leetcode257;

import org.home.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        if (root.left == null && root.right == null){
            res.add(String.valueOf(root.val));
            return res;
        }
        List<String> resLeft = binaryTreePaths(root.left);
        resLeft.forEach(ele -> res.add(String.valueOf(root.val) + "->" + ele));
        List<String> resRight = binaryTreePaths(root.right);
        resRight.forEach(ele -> res.add(String.valueOf(root.val) + "->" + ele));
        return res;
    }
}