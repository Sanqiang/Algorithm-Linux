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

    //my way
    public int maxProfitEx(int[] prices) {
        int max = 0;
        int buy_date = 0, i, length = prices.length;
        for (i = 1; i < length; i++) {
            if (prices[i] < prices[i - 1]) {
                max += prices[i - 1] - prices[buy_date];
                buy_date = i;
            }
        }
        max += prices[length - 1] - prices[buy_date];
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {2, 3, 1, 2, 3, 2, 9, 10};
        int profit = new Q9_BestTimeBuySellStock2().maxProfit(prices);
        System.out.println(profit);
        int profit2 = new Q9_BestTimeBuySellStock2().maxProfitEx(prices);
        System.out.println(profit2);
    }
}
