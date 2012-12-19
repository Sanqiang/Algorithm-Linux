/**
 * Sanqiang Zhao Www.131X.Com Dec 17, 2012
 */
package LeetCode.OnlineJudge;

public class Q8_BestTimeBuySellStock {

    public int maxProfit(int[] prices) {
        int MaxProfitVal = Integer.MIN_VALUE, i = 1, length = prices.length;
        int buy_day = 0;
        for (; i < length; ++i) {
            int profit = prices[i] - prices[buy_day];
            if (profit > MaxProfitVal) {
                MaxProfitVal = profit;
            }
            buy_day = prices[i] < prices[buy_day] ? i : buy_day;
        }
        return MaxProfitVal;

    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 9, 3, 4, 2, 1, 10};
        int profit = new Q8_BestTimeBuySellStock().maxProfit(prices);
        System.out.println(profit);
    }
}
