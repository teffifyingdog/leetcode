package com.wjc.lc.twenty.tree.twelve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Date 2020/3/12 0012 下午 23:25
 * @Created by wjc
 *
 * 链接
 *  https://leetcode-cn.com/problems/generate-parentheses/
 */

class Solution3 {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        test(n*2,list,0,0,"");
        return list;
    }
    /**
     * @description
     * @date 2020/3/12 0012
     * @param end
     * @param list
     * @param left
     * @param right
     * @param crr
     */
    public void test(int end, ArrayList<String> list, int left, int right, String crr) {
        if (left+right == end)
            list.add(crr);
        if (left < end/2)
            test(end,list,left+1,right,crr+"(");

        if (right < left)
            test(end,list,left,right+1,crr+")");
    }
}

public class 括号生成 {
    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            List<String> ret = new Solution3().generateParenthesis(n);

            String out = stringListToString(ret);

            System.out.print(out);
        }
    }
}