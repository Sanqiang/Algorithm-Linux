/**
 * Sanqiang Zhao Www.131X.Com Dec 17, 2012
 */
package LeetCode.OnlineJudge;

public class Q9_BestTimeBuySellStock2 {

    public int maxProfit(int[] prices) {
        int i = 1, length = prices.length, buy_day = 0;
        int MaxProfitVal = 0;
        for (; i < length; ++i) {
            if (prices[i] >= prices[i - 1]) {
                continue;
            }
            MaxProfitVal += prices[i - 1] - prices[buy_day];
            buy_day = i;
        }
        if (prices[i - 1] > prices[buy_day]) {
            MaxProfitVal += prices[i - 1] - prices[buy_day];
        }
        return MaxProfitVal;
    }

    public static void main(String[] args) {
        int[] prices = {2, 3, 1, 2, 3, 2, 9, 10};
        int profit = new Q9_BestTimeBuySellStock2().maxProfit(prices);
        System.out.println(profit);
    }
}
