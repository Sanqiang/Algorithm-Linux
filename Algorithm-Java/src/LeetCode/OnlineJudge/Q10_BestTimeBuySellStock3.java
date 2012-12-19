/**
 * Sanqiang Zhao Www.131X.Com Dec 17, 2012
 */
package LeetCode.OnlineJudge;

import java.util.ArrayList;
import sun.misc.JavaxSecurityAuthKerberosAccess;

public class Q10_BestTimeBuySellStock3 {
    
    public int maxProfit(int[] prices) {
        int i = 1, length = prices.length, MaxProfitVal = Integer.MIN_VALUE;
        int[] left = new int[length];
        int[] right = new int[length];
        int buy_day = 0;
        for (i = 1; i < length; ++i) {
            left[i] = prices[i] - prices[buy_day];
            buy_day = prices[i] < prices[buy_day] ? i : buy_day;
        }
        int sell_day = length - 1;
        for (i = length - 2; i >= 0; --i) {
            right[i] = prices[sell_day] - prices[i];
            sell_day = prices[i] > prices[sell_day] ? i : sell_day;
        }
        for (i = 1; i < length; i++) {
            int current_profit = left[i - 1] + right[i];
            if (current_profit > MaxProfitVal) {
                MaxProfitVal = current_profit;
            }
        }
        return MaxProfitVal;
    }
    
    public static void main(String[] args) {
        int[] prices = {2, 3, 1, 2, 7, 2, 9, 10};
        int profit = new Q10_BestTimeBuySellStock3().maxProfit(prices);
        System.out.println(profit);
    }
}
