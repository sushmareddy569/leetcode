package practice;

import java.util.Arrays;

//719 - Find K-th Smallest Pair Distance

public class FindKthSmallestPairDistance {
	// time complexity for sorting is O(n log n) + binary search for
	// (0, maxDistance) is O(log maxDistance) * n [for the sliding window
	// inside]
	// total - O(n log n) + O(n log maxDistance)
	public int smallestDistancePair(int[] nums, int k) {
		Arrays.sort(nums);
		int n = nums.length;

		int low = 0, high = nums[n - 1] - nums[0];

		while (low < high) {
			int mid = low + (high - low) / 2;
			int countOfPairs = 0;
			int left = 0, right = 0;

			for (right = 0; right < n; right++) {

				while (nums[right] - nums[left] > mid) {
					left++;
				}

				countOfPairs = countOfPairs + (right - left);
			}

			if (countOfPairs >= k) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	public static void main(String[] args) {
		FindKthSmallestPairDistance f = new FindKthSmallestPairDistance();
		int[] input1 = { 1, 3, 1, 5, 4, 7 };
		int val = 1;
		int result = f.smallestDistancePair(input1, val);
		System.out.println(result);
	}
}
