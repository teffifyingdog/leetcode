package com.wjc.lc.twentyone.twelve.thirty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class MaskTest {
    private static int[] ints = {0, 128, 192, 224, 240, 248, 252, 254, 255};
    private static HashSet<Integer> set =new HashSet();
    static {
        set.add(0);
        set.add(128);
        set.add(192);
        set.add(224);
        set.add(240);
        set.add(248);
        set.add(252);
        set.add(254);
        set.add(255);
    }
    public static void main(String[] args) {
        System.out.println(Integer.valueOf("00000000",2));
        System.out.println(Integer.parseInt("10000000",2));
        System.out.println(Integer.parseInt("11000000",2));
        System.out.println(Integer.parseInt("11100000",2));
        System.out.println(Integer.parseInt("11110000",2));
        System.out.println(Integer.parseInt("11111000",2));
        System.out.println(Integer.parseInt("11111100",2));
        System.out.println(Integer.parseInt("11111110",2));
        System.out.println(Integer.parseInt("11111111",2));
        System.out.println(Integer.toBinaryString(4));
        System.out.println(isValidMask("178.136.80.23"));
        System.out.println(isValidMask("255.0.0.0"));
        System.out.println(isValidMask("255.0.0.4"));
        System.out.println(isValidMask("178.136.80.23~255.0.0.0"));
        System.out.println(isValidMask("178.136.80.23~255.0.0.0"));
        System.out.println(isValidMask("178.136.80.23~255.0.0.0"));
    }

    public static boolean isValidMask(String mask) {
        if (!isValidIp(mask)) {
            return false;
        }
        String[] maskTable = mask.split("\\.");
        //mask转为32位2进制字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maskTable.length; i++) {
            maskTable[i] = Integer.toBinaryString(Integer.parseInt(maskTable[i]));
            if (maskTable[i].length() < 8) {//不足8位补齐0
                for (int j = 0; j < 8 - maskTable[i].length(); j++) {
                    sb.append("0");//补完零
                }
                sb.append(maskTable[i]);//再添加转换的2进制串
            } else {
                sb.append(maskTable[i]);//刚好8位直接添加，因为之前已经判断过ip的有效性，所以不可能超过8位
            }
        }
        //最后一个1在第一个0之前，有效，否则无效
        return sb.toString().lastIndexOf("1") < sb.toString().indexOf("0");
    }

    public static boolean isValidIp(String ip) {
        String[] ipTable = ip.split("\\.");
        if (ipTable.length != 4) {
            return false;
        }
        for (String s : ipTable) {
            if (Integer.parseInt(s) < 0 || Integer.parseInt(s) > 255) {
                return false;
            }
        }
        return true;
    }
}
