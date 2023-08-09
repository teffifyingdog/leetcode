package com.wjc.lc.twentythree.two.nine;

import java.util.HashMap;
import java.util.Map;

public class 设计一个验证系统 {
}
class AuthenticationManager {
    private int timeToLive = 0;
    private Map<String,Integer> map = new HashMap<>();

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId,currentTime+timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if (map.getOrDefault(tokenId,0)>currentTime) {
            map.put(tokenId,currentTime+timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int i = 0;
        for (Integer value : map.values()) {
            if (value>currentTime&&value-timeToLive<currentTime){
                i++;
            }
        }
        return i;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */