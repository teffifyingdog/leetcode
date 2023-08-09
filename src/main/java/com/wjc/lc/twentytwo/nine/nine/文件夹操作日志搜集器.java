package com.wjc.lc.twentytwo.nine.nine;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://leetcode.cn/problems/crawler-log-folder/
 */
class Solution {
    public int minOperations(String[] logs) {
        int res = 0;
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals("../")){
                res = res > 0 ? res - 1 : 0;
            }else if (logs[i].equals("./")){

            }else {
                res++;
            }
        }
        return res;
    }
}

public class 文件夹操作日志搜集器 {
    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] logs = stringToStringArray(line);

            int ret = new Solution().minOperations(logs);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

}