package practice;

// 122 - Best Time to Buy and Sell Stock II

public class BestTimeToBuyAndSellStockII {
	public int maxprofit(int[] prices) {
		int i = 0;
		int n = prices.length;
		int minPrice = prices[0];
		int maxProfit = prices[0];
		int totalProfit = 0;

		while (i < n - 1) {
			while (i < n - 1 && prices[i] >= prices[i + 1]) {
				i++;
			}
			minPrice = prices[i];
			while (i < n - 1 && prices[i] <= prices[i + 1]) {
				i++;
			}
			maxProfit = prices[i];

			totalProfit = totalProfit + maxProfit - minPrice;
		}

		return totalProfit;
	}

	public int maxProfit1(int[] prices) {
		int maxProfit = 0;

		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i + 1] > prices[i]) {
				int currentProfit = prices[i + 1] - prices[i];
				maxProfit = maxProfit + currentProfit;
			}
		}
		return maxProfit;
	}
}
