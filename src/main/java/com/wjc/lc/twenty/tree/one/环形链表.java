package com.wjc.lc.twenty.tree.one;

import com.wjc.lc.twenty.two.sixteen.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * @Description
 * @Date 2020/3/1 0001 下午 13:27
 * @Created by wjc
 *
 * 连接
 *  https://leetcode-cn.com/problems/linked-list-cycle/
 */


class Solution {
    public boolean hasCycle(ListNode head, int pos) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while (head.next !=null){
            boolean res = hashSet.add(head);
            if (res == false){
                return true;
            }
            head= head.next;
        }
        return false;
    }
}

public class 环形链表 {
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);
            line = in.readLine();
            int pos = Integer.parseInt(line);

            boolean ret = new Solution().hasCycle(head,pos);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}