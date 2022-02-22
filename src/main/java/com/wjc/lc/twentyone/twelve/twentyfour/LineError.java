package com.wjc.lc.twentyone.twelve.twentyfour;

import java.util.HashMap;
import java.util.Scanner;

public class LineError {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            String[] s = next.split(" ");
            String file = s[0];
            Integer lineNumber = Integer.valueOf(s[1]);
            String fileName = file.substring(file.lastIndexOf("\\")+1, file.length());
            if (fileName.length() > 16) {
                fileName = fileName.substring(fileName.length() - 16);
            }
            String errorName = fileName + " " + lineNumber;
            Integer num = map.get(errorName);
            if (num != null) {
                map.put(errorName, ++num);
            } else {
                if (map.size() < 8) {
                    map.put(errorName, 1);
                }
            }
            if (map.size() > 0) {
                map.forEach((k, v) -> {
                    System.out.println(k + " " + v);
                });
            }
        }
    }
}
