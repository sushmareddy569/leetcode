package practice;

// 268 - Missing Number

public class MissingNumber {
	public int missingNumber(int[] nums) {
		int result = nums.length;
		for (int i = 0; i < nums.length; i++) {
			result ^= i;
			result ^= nums[i];
		}
		return result;
	}

	public int missingNumber1(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		return (nums.length * (nums.length + 1)) / 2 - sum;
	}
}
