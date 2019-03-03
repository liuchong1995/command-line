package org.home.bst.l145;

import org.home.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<Command> commandStack = new Stack<>();
        commandStack.push(new Command(1, root));
        while (!commandStack.isEmpty()) {
            Command command = commandStack.pop();
            if (command.code == 0)
                res.add(command.treeNode.val);
            else {
                commandStack.push(new Command(0, command.treeNode));
                if (command.treeNode.right != null)
                    commandStack.push(new Command(1, command.treeNode.right));
                if (command.treeNode.left != null)
                    commandStack.push(new Command(1, command.treeNode.left));
            }
        }
        return res;
    }

    class Command {
        int code; // 0： 访问当前节点    1： 去访问指定节点
        TreeNode treeNode;

        Command(int code, TreeNode treeNode) {
            this.code = code;
            this.treeNode = treeNode;
        }
    }
}