package practice;

import java.util.HashSet;
import java.util.Set;

// 238 -  Product of Array Except Self

public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length == 1) {
			return nums;
		}
		int n = nums.length;
		int[] result = new int[n];
		int prod = 1;
		result[0] = 1;

		for (int i = 1; i < n; i++) {
			prod = prod * nums[i - 1];
			result[i] = prod;
		}

		prod = 1;
		for (int i = n - 2; i >= 0; i--) {
			prod = prod * nums[i + 1];
			result[i] = result[i] * prod;
		}
		return result;
	}

	public int[] productExceptSelf1(int[] nums) {
		int n = nums.length;
		int prod = 1;
		Set<Integer> zeroIndices = new HashSet<>();

		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				zeroIndices.add(i);
			} else {
				prod = prod * nums[i];
			}
		}
		int[] result = new int[n];
		if (zeroIndices.size() > 1) {
			return result;
		}

		for (int i = 0; i < n; i++) {
			if (zeroIndices.isEmpty()) {
				result[i] = prod / nums[i];
			} else if (zeroIndices.contains(i)) {
				result[i] = prod;
			} else {
				result[i] = 0;
			}
		}
		return result;
	}
}
