package com.wjc.lc.twentytwo.seven.four;

import com.wjc.common.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/n-ary-tree-preorder-traversal/
 */
class Solution1 {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        sout(root,res);
        return res;
    }
    public void sout(Node root,List<Integer> res){
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node child : root.children) {
            sout(child,res);
        }
    }
}

public class N叉树的前序遍历 {
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int root = Integer.parseInt(line);

            List<Integer> ret = new Solution1().preorder(new Node(root));

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}