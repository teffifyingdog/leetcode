package com.wjc.lc.twenty.tree.five;

import com.wjc.lc.twenty.two.sixteen.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description
 * @Date 2020/3/5 0005 下午 14:37
 * @Created by wjc
 * <p>
 * 连接
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */


class Solution {
    ListNode tempHead = null;

    public boolean isPalindrome(ListNode head) {
        tempHead = head;
        return test(tempHead);
    }

    /**
     * @description
     * @date 2020/3/5 0005
     */
    public boolean test(ListNode head) {
        if (head != null) {
            if (!test(head.next)) return false;
            if (head.val != tempHead.val) return false;
            tempHead = tempHead.next;
        }
        return true;
    }
}

public class 回文链表 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            boolean ret = new Solution().isPalindrome(head);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}