/**
 * Sanqiang Zhao Www.131X.Com Dec 17, 2012
 */
package LeetCode.OnlineJudge;

public class Q10_BestTimeBuySellStock3 {

    //wrong
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

    //my way
    public int maxProfitEx(int[] prices) {
        int max = Integer.MIN_VALUE;
        int length = prices.length, i;
        int[] left = new int[length];
        int sell_date = 0;
        int buy_date = 0;
        for (i = 1; i < length; i++) {
            if (prices[i] < prices[buy_date]) {
                buy_date = i;
            }
            if (prices[sell_date] < prices[i] && i > buy_date) {
                sell_date = i;
            }
            left[i] = prices[sell_date] - prices[buy_date];
        }
        int[] right = new int[length];
        sell_date = length - 1;
        buy_date = length - 1;
        for (i = length - 2; i >= 0; i--) {
            if (prices[i] > prices[sell_date]) {
                sell_date = i;
            }
            if (prices[buy_date] > prices[i] && i < sell_date) {
                buy_date = i;
            }
            right[i] = prices[sell_date] - prices[buy_date];

        }
        for (i = 1; i < length; i++) {
            max = Math.max(max, left[i - 1] + right[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {2, 3, 1, 100, 7, 2, 9, 10};
        int profit = new Q10_BestTimeBuySellStock3().maxProfit(prices);
        System.out.println(profit);
        int profit2 = new Q10_BestTimeBuySellStock3().maxProfitEx(prices);
        System.out.println(profit2);
    }
}
