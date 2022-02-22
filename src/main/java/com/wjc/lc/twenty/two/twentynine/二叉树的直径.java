package com.wjc.lc.twenty.two.twentynine;

import com.wjc.lc.twenty.two.fifteen.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @Date 2020/2/29 0029 下午 19:24
 * @Created by wjc
 *
 * 连接
 *  https://leetcode-cn.com/problems/diameter-of-binary-tree/
 */

class Solution3 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null)
            return 0;
        test(root);
        return max;
    }
    /**
     * @description
     * @date 2020/2/29 0029
     */
    public int test(TreeNode root) {
        if (root == null)
            return 0;
        int right = test(root.right);
        int left = test(root.left);
        max = Math.max(max,right+left);
        return Math.max(right, left)+1;
    }
}

public class 二叉树的直径 {
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new Solution3().diameterOfBinaryTree(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}