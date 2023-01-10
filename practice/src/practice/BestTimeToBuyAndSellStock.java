package practice;

// 121 - Best Time to Buy and Sell Stock

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE;
		int max = 0;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else if (prices[i] - min > max) {
				max = prices[i] - min;
			}
		}
		return max;
	}
}
