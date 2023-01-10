package practice;

//410 - Split Array Largest Sum

public class SplitArrayLargestSum {
	public int splitArray(int[] nums, int m) {
		int max = 0, sum = 0;

		for (int num : nums) {
			max = Math.max(max, num);
			sum = sum + num;
		}

		int lowestSum = max;
		int highestSum = sum;
		while (lowestSum < highestSum) {
			int midSum = (lowestSum + highestSum) / 2;

			System.out.println("low : " + lowestSum);
			System.out.println("high : " + highestSum);
			System.out.println("mid : " + midSum);

			int count = findCount(nums, midSum);
			if (count <= m - 1) {
				highestSum = midSum;
			} else {
				lowestSum = midSum + 1;
			}
		}
		return lowestSum;
	}

	private int findCount(int[] nums, int midSum) {
		int count = 0;
		long currentSum = 0;

		for (int num : nums) {
			currentSum = currentSum + num;
			if (currentSum > midSum) {
				currentSum = num;
				count++;
			}
		}
		System.out.println("Count is: " + count);
		return count;
	}

	public static void main(String[] args) {
		SplitArrayLargestSum s = new SplitArrayLargestSum();
		int[] input1 = { 1, 4, 4 };
		int val = 3;
		int result = s.splitArray(input1, val);
		System.out.println(result);
	}
}
