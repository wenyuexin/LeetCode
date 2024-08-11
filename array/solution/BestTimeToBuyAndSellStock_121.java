package array.solution;

import java.util.Arrays;

/**
 * @author Apollo4634
 * @create 2019/10/07
 * @problem 40
 * @tag Array
 * @tag Dynamic Programming
 */

public class BestTimeToBuyAndSellStock_121 {
    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2) return 0;
            int maxProfit = 0;
            int buyingPrice = prices[0];
            int size = prices.length;
            for (int i = 1; i < size; i++) {
                if (prices[i] > buyingPrice) {
                    int profit = prices[i] - buyingPrice;
                    if (profit > maxProfit) maxProfit = profit;
                } else {
                    buyingPrice = prices[i];
                }
            }
            return maxProfit;
        }
    }


    public static void main(String[] args) {
        //int[] prices = new int[] { 7,1,5,3,6,4 };
        int[] prices = new int[] { 7,6,4,3,1 };
        System.out.println("Input:  "+ Arrays.toString(prices));

        long t1 = System.nanoTime();
        int ret = new Solution().maxProfit(prices);
        long t2 = System.nanoTime();

        System.out.println("Output: "+ ret);
        System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
    }
}
