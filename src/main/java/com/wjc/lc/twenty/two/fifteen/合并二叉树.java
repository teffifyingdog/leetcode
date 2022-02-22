package com.wjc.lc.twenty.two.fifteen;/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 *
 * 结果
 * [1,3,2,5]
 * [2,1,3,null,4,null,7]
 * [3, 4, 5, 5, 4, null, 7, null, null, null, null, null, null]
 *
 * 题目链接
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 */
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//        if (t1 == null)
//            return t2;
//        if (t2 == null)
//            return t1;
//        t1.val += t2.val;
//        t1.left = mergeTrees(t1.left, t2.left);
//        t1.right = mergeTrees(t1.right, t2.right);
//        return t1;
        TreeNode t = new TreeNode(t1.val + t2.val);
        t = recursive(t1, t2, t);
        return t;
    }

    public TreeNode recursive(TreeNode t1, TreeNode t2, TreeNode t) {

        if ((t1 != null && t1.left != null) || (t2 != null && t2.left != null)) {
            t.left = new TreeNode(Optional.ofNullable(t1).map(left -> left.left).map(left -> left.val).orElse(0) + Optional.ofNullable(t2).map(left -> left.left).map(left -> left.val).orElse(0));
            recursive(t1.left, t2.left, t.left);
        }
        if ((t1 != null && t1.right != null) || (t2 != null && t2.right != null)) {
            t.right = new TreeNode(Optional.ofNullable(t1).map(right -> right.right).map(right -> right.val).orElse(0) + Optional.ofNullable(t2).map(right -> right.right).map(right -> right.val).orElse(0));
            recursive(t1.right, t2.right, t.right);
        }
        return t;
    }

}

public class 合并二叉树 {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode t1 = stringToTreeNode(line);
            line = in.readLine();
            TreeNode t2 = stringToTreeNode(line);

            TreeNode ret = new Solution().mergeTrees(t1, t2);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}