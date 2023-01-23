package practice;

// 875 - Koko Eating Bananas

public class KokoEatingBananas {
	public int minEatingSpeed(int[] piles, int h) {
		int low = 1;
		int high = getMaxPile(piles);

		while (low < high) {
			int mid = low + (high - low) / 2;
			if (canEatAll(piles, mid, h)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	private int getMaxPile(int[] piles) {
		int maxPile = Integer.MIN_VALUE;
		for (int pile : piles) {
			maxPile = Math.max(pile, maxPile);
		}
		return maxPile;
	}

	private boolean canEatAll(int[] piles, int k, int h) {
		int countHour = 0;

		for (int pile : piles) {
			countHour = countHour + pile / k;

			if (pile % k != 0) {
				countHour++;
			}
		}
		return countHour <= h;
	}

	public int minEatingSpeed1(int[] piles, int h) {
		int left = 1;
		int right = getMaxPile(piles);

		while (left < right) {
			int mid = (left + right) / 2;
			int hourSpent = 0;

			for (int pile : piles) {
				hourSpent += Math.ceil((double) pile / mid);
			}
			if (hourSpent <= h) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}
}
