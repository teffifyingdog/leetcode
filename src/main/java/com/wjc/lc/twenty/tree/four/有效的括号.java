package com.wjc.lc.twenty.tree.four;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * @Description
 * @Date 2020/3/4 0004 下午 22:34
 * @Created by wjc
 * <p>
 * 连接
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> list = new LinkedList<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='(') {
                list.addLast('(');
            }
            if (chars[i]==')'){
                if (list.size()==0)
                    return false;
                if (list.getLast() !='(')
                    return false;
                else
                    list.removeLast();
            }
            if (chars[i]=='{') {
                list.addLast('{');
            }
            if (chars[i]=='}'){
                if (list.size()==0)
                    return false;
                if (list.getLast() !='{')
                    return false;
                else
                    list.removeLast();
            }
            if (chars[i]=='[') {
                list.addLast('[');
            }
            if (chars[i]==']'){
                if (list.size()==0)
                    return false;
                if (list.getLast() !='[')
                    return false;
                else
                    list.removeLast();
            }
        }
        return list.size()==0?true:false;
    }
}

public class 有效的括号 {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return input;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            boolean ret = new Solution().isValid(s);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}