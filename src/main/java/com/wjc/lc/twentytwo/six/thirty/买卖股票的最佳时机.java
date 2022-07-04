package com.wjc.lc.twentytwo.six.thirty;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 */
public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }else if (prices[i] - min > res){
                res = prices[i] - min;
            }
        }
        return res;
    }
}
