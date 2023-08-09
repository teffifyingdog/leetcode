package com.wjc.lc.twentythree.one.thirty;

import com.wjc.lc.twenty.two.sixteen.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://leetcode.cn/problems/merge-in-between-linked-lists/
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp = list1;
        for (int i = 1; i < a; i++) {
            temp = temp.next;
        }
        ListNode next = temp.next;
        for (int i = 0; i < (b-a+1); i++) {
            next = next.next;
        }
        temp.next = list2;
        while (list2.next != null){
            list2 = list2.next;
        }
        list2.next = next;
        return list1;
    }
}

public class 合并两个链表 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
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
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode list1 = stringToListNode(line);
            line = in.readLine();
            int a = Integer.parseInt(line);
            line = in.readLine();
            int b = Integer.parseInt(line);
            line = in.readLine();
            ListNode list2 = stringToListNode(line);

            ListNode ret = new Solution().mergeInBetween(list1, a, b, list2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}