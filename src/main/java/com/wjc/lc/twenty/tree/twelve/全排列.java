package com.wjc.lc.twenty.tree.twelve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Description
 * @Date 2020/3/12 0012 下午 16:52
 * @Created by wjc
 * <p>
 * 链接
 * https://leetcode-cn.com/problems/permutations/
 */

class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            linkedList.add(nums[i]);
        }
        List<List<Integer>> lists = new LinkedList<>();

        test(length,lists,linkedList,0);
        return lists;

    }
    /**
     * @description
     * @date 2020/3/12 0012
     * @param length
     * @param lists
     * @param linkedList
     * @param count
     */
    public void test(int length, List<List<Integer>> lists, LinkedList<Integer> linkedList, int count) {
        if (count == length)
            lists.add(new LinkedList<>(linkedList));
        for (int i = count; i < length; i++) {
            Collections.swap(linkedList,count,i);
            test(length,lists,linkedList,count+1);
            Collections.swap(linkedList,count,i);
        }
    }



}

public class 全排列 {
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

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list : nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            List<List<Integer>> ret = new Solution2().permute(nums);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}
class test2{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("list = " + list);
        Collections.swap(list,0,0);
        System.out.println("list = " + list);
        Collections.swap(list,0,2);
        System.out.println("list = " + list);
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        int i = 0;
//        while (i<1000){
//            arrayList.add(i);
//            i++;
//        }
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        int j = 0;
//        while (j<1000){
//            linkedList.add(i);
//            j++;
//        }
//        long s1 = System.currentTimeMillis();
//        for (int a = 0; a < 100000; a++) {
//            Collections.swap(arrayList,(int) Math.random()*999,(int)Math.random()*999);
//        }
//        long s2 = System.currentTimeMillis();
//        long s3 = System.currentTimeMillis();
//        for (int a = 0; a < 100000; a++) {
//            Collections.swap(linkedList,(int) Math.random()*999,(int)Math.random()*999);
//        }
//        long s4 = System.currentTimeMillis();
//        System.out.println(s2-s1);
//        System.out.println(s4-s3);
    }
}