package org.home.leetcode102;


import javafx.util.Pair;

import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        LinkedList<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(root,0));
        while (!queue.isEmpty()){
            Pair<TreeNode, Integer> pair = queue.pollFirst();
            int val = pair.getKey().val;
            Integer level = pair.getValue();
            if (level == res.size())
                res.add(new ArrayList<>());
            res.get(level);
            if (pair.getKey().left != null)
                queue.addLast(new Pair<>(pair.getKey().left,level + 1));
            if (pair.getKey().right != null)
                queue.addLast(new Pair<>(pair.getKey().left,level + 1));
        }
        return res;
    }
}
//Definition for a binary tree node.

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}