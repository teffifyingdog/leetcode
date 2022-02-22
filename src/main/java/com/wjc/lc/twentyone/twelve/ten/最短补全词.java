package com.wjc.lc.twentyone.twelve.ten;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class 最短补全词 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] ints = new int[26];
        char[] array = licensePlate.toCharArray();
        for (char c : array) {
            if (Character.isLetter(c)) {
                ++ints[Character.toLowerCase(c) - 'a'];
            }
        }
        int idx = -1;
        for (int i = 0; i < words.length; i++) {
            int[] is = new int[26];
            for (char c : words[i].toCharArray()) {
                if (Character.isLetter(c)) {
                    ++is[Character.toLowerCase(c) - 'a'];
                }
            }
            boolean ok = true;
            for (int j = 0; j < 26; j++) {
                if (ints[j] > is[j]){
                    ok = false;
                    break;
                }
            }
            if (ok && (idx < 0 || words[idx].length() > words[i].length())){
                idx = i;
            }
        }
        return words[idx];

    }

    private boolean compare(HashMap<Byte, Integer> map, HashMap<Byte, Integer> hashMap) {
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            Byte k = entry.getKey();
            Integer v = entry.getValue();
            if (hashMap.get(k)==null || hashMap.get(k) < v) {
                return false;
            }
        }
        return true;
    }

    private HashMap<Byte, Integer> getMap(String s) {
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        HashMap<Byte, Integer> map = new HashMap<>();
        for (byte aByte : bytes) {
            Integer integer = map.get(aByte);
            if (integer != null) {
                map.put(aByte, integer + 1);
            } else {
                map.put(aByte, 0);
            }
        }
        return map;
    }
}

class MainClass {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return JSON.toJSONString(input);
    }

    public static String[] stringToStringArray(String input) {
        JSONArray jsonArray = JSONArray.parseArray(input);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).toString();
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String licensePlate = stringToString(line);
            line = in.readLine();
            String[] words = stringToStringArray(line);

            String ret = new 最短补全词().shortestCompletingWord(licensePlate, words);

            String out = (ret);

            System.out.print(out);
        }
    }
}