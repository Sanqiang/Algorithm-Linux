package Lintcode.Intensive.L5;

public class MaxProfit {
	/**
	 * @param prices:
	 *            Given an integer array
	 * @return: Maximum profit
	 */
	public int maxProfit(int[] prices) {
		int max_profit = 0;
		if (prices == null || prices.length <= 1) {
			return max_profit;
		}

		int min_invest = prices[0];
		for (int i = 1; i < prices.length; i++) {
			max_profit = Math.max(max_profit, prices[i] - min_invest);
			min_invest = Math.min(min_invest, prices[i]);
		}

		return max_profit;
	}

	/**
	 * @param prices:
	 *            Given an integer array
	 * @return: Maximum profit
	 */
	public int maxProfit2(int[] prices) {
		int profit = 0;
		if (prices == null || prices.length == 0) {
			return profit;
		}

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				profit += prices[i] - prices[i - 1];
			}
		}

		return profit;
	}

	/**
	 * @param prices:
	 *            Given an integer array
	 * @return: Maximum profit
	 */
	public int maxProfit3(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		int min_invest = prices[0];
		int[] left_profit = new int[prices.length];
		left_profit[0] = 0;
		for (int i = 1; i < prices.length; i++) {
			min_invest = Math.min(min_invest, prices[i]);
			left_profit[i] = Math.max(left_profit[i - 1], prices[i] - min_invest);
		}

		int max_sold = prices[prices.length - 1];
		int[] right_profit = new int[prices.length];
		right_profit[prices.length - 1] = 0;
		for (int i = prices.length - 2; i >= 0; i--) {
			max_sold = Math.max(max_sold, prices[i]);
			right_profit[i] = Math.max(right_profit[i + 1], max_sold - prices[i]);
		}

		int max_profit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			max_profit = Math.max(max_profit, left_profit[i] + right_profit[i]);
		}

		return max_profit;
	}

	/**
	 * @param k:
	 *            An integer
	 * @param prices:
	 *            Given an integer array
	 * @return: Maximum profit
	 */
	public int maxProfit4(int k, int[] prices) {
		return -1;
	}
}
