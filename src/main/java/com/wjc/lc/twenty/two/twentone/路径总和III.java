package com.wjc.lc.twenty.two.twentone;

import com.wjc.lc.twenty.two.fifteen.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
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
 * 链接
 *  https://leetcode-cn.com/problems/path-sum-iii/
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        return test(root, sum, new int[1000], 0);
    }

    public int test(TreeNode root, int sum, int[] arr, int count) {
        if (root == null)
            return 0;
        int a = root.val == sum ? 1 : 0;
        int temp = root.val;
        for (int i = count - 1; i >= 0; i--) {
            temp += arr[i];
            if (temp == sum) {
                a++;
            }
            //有可能时负的，所以不需要break
//            if (temp > sum){
//                break;
//            }
        }
        arr[count] = root.val;
        int b = test(root.left, sum, arr, count + 1);
        int c = test(root.right, sum, arr, count + 1);
        return a + b + c;
    }
}

public class 路径总和III {
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            int sum = Integer.parseInt(line);

            int ret = new Solution().pathSum(root, sum);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}