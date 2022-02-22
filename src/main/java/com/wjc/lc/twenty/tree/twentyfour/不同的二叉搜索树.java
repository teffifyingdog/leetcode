package com.wjc.lc.twenty.tree.twentyfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description
 * @Date 2020/3/24 0024 下午 14:08
 * @Created by wjc
 *
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 */

class Solution2 {
    public int numTrees(int n) {
        // Note: we should use long here instead of int, otherwise overflow
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}

public class 不同的二叉搜索树 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Solution2().numTrees(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
class test{
    public static void main(String[] args) {

        Integer i1 = 3340;
        Integer i2 = 3340;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);
        System.out.println("i1=i2 " + (i1 == i2));
        System.out.println("i1=i2+i3 " + (i1 == i2 + i3));
        System.out.println("i1=i4 " + (i1 == i4));
        System.out.println("i4=i5 " + (i4 == i5));
        System.out.println("i4=i5+i6 " + (i4 == i5 + i6));
        System.out.println("40=i5+i6 " + (40 == i5 + i6));

    }
}