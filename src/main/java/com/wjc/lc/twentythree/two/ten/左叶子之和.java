package com.wjc.lc.twentythree.two.ten;


import com.wjc.lc.twenty.two.fifteen.TreeNode;

class 左叶子之和 {
    public int sumOfLeftLeaves(TreeNode root) {

        return extracted(root, false);
    }

    private int extracted(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && isLeft) {
            return root.val;
        } else {
            return extracted(root.left, true) + extracted(root.right, false);
        }
    }
}