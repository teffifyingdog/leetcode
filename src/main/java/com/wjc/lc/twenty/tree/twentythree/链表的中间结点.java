package com.wjc.lc.twenty.tree.twentythree;

import com.wjc.lc.twenty.two.sixteen.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Date 2020/3/23 0023 下午 13:33
 * @Created by wjc
 * <p>
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
//        if (head == null)
//            return null;
//
//        LinkedList<ListNode> linkedList = new LinkedList<>();
//        ListNode temp = head;
//        while (temp != null){
//            linkedList.add(temp);
//            temp = temp.next;
//        }
//        System.out.println(linkedList.size()/2+1);
//        return linkedList.get(linkedList.size()/2);
    }
}

class test {
    public static void main(String[] args) {
        System.out.println("5/2 = " + 5 / 2);
    }
}

public class 链表的中间结点 {
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
            ListNode head = stringToListNode(line);

            ListNode ret = new Solution().middleNode(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}