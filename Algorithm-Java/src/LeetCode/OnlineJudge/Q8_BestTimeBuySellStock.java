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

    //my way
    public int maxProfitEx(int[] prices) {
        int max = Integer.MIN_VALUE;
        int i, length = prices.length;
        int buy_date = 0;
        for (i = 1; i < length; i++) {
            if (prices[i] < prices[buy_date]) {
                buy_date = i;
            }
            max = Math.max(max, prices[i] - prices[buy_date]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 9, 3, 4, 2, 1, 10};
        int profit = new Q8_BestTimeBuySellStock().maxProfit(prices);
        System.out.println(profit);
        
        int profit2 = new Q8_BestTimeBuySellStock().maxProfitEx(prices);
        System.out.println(profit2);
    }
}
