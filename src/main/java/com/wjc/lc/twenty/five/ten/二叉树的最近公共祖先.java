package com.wjc.lc.twenty.five.ten;

/**
 * @Description
 * @Date 2020/5/10 0010 下午 16:24
 * @Created by wjc
 */


import com.wjc.lc.twenty.two.fifteen.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


class Solution {
    private TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        test(root,p,q);
        return res;
    }
    /**
     * @description
     * @date 2020/5/10 0010
     */
    public boolean test(TreeNode root, int p, int q) {
        if (root == null)
            return false;
        boolean rres = test(root.right, p, q);
        boolean lres = test(root.left, p, q);
        if ((rres&&lres)||((root.val==p||root.val==q)&&(rres||lres)))
            res = root;
        return rres||lres||root.val==p||root.val==q;
    }
}

class MainClass {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
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
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
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
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            int p = Integer.parseInt(line);
            line = in.readLine();
            int q = Integer.parseInt(line);

            TreeNode ret = new Solution().lowestCommonAncestor(root, p, q);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}