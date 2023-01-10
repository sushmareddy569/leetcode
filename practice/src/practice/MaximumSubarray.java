package practice;

// 53 - Maximum Subarray

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			if (sum < 0) {
				sum = nums[i];
			} else {
				sum += nums[i];
			}
			max = Math.max(max, sum);
		}
		return max;
	}

	public int maxSubarry(int[] nums) {
		if (nums == null || nums.length < 1) {
			return 0;
		}
		int maxCurr = nums[0];
		int maxSoFar = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxCurr = Math.max(nums[i], maxCurr + nums[i]);
			maxSoFar = Math.max(maxSoFar, maxCurr);
		}
		return maxSoFar;
	}
}
