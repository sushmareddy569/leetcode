package practice;

// 152 - Maximum Product Subarray

public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		int maxCurr = nums[0];
		int minCurr = nums[0];
		int maxSoFar = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int current = nums[i];

			if (current < 0) {
				int temp = maxCurr;
				maxCurr = minCurr;
				minCurr = temp;
			}
			maxCurr = Math.max(current, maxCurr * current);
			minCurr = Math.min(current, minCurr * current);
			maxSoFar = Math.max(maxSoFar, maxCurr);
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		MaximumProductSubarray max = new MaximumProductSubarray();

		int[] nums = { -2, 3, -4 };
		System.out.println(max.maxProduct(nums));
	}
}
