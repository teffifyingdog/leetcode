package com.wjc.lc.twentythree.tree.five;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/making-file-names-unique/
 */

public class 保证文件名唯一 {
    public String[] getFolderNames(String[] names) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (map.containsKey(name)) {
                Integer k = map.get(name);
                while (map.containsKey(getName(name,k))){
                    k++;
                }
                res[i] = getName(name,k);
                map.put(name,k);
                map.put(getName(name,k),1);
            } else {
                res[i] = name;
                map.put(name,1);
            }
        }
        return res;
    }

    private String getName(String name,int i) {
        return name + "(" + i + ")";
    }
}