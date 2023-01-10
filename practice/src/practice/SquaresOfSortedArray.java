package practice;

//977 - Squares of a Sorted Array

public class SquaresOfSortedArray {
	public static int[] sortedSquares(int[] nums) {
		int n = nums.length;
		int[] resarr = new int[n];
		int i = 0, j = n - 1;
		for (int k = n - 1; k >= 0; k--) {
			if (Math.abs(nums[i]) > Math.abs(nums[j])) {
				resarr[k] = nums[i] * nums[i];
				i++;
			} else {
				resarr[k] = nums[j] * nums[j];
				j--;
			}
		}
		/*
		 * for (int i = 0; i < n; i++) { nums[i] = nums[i] * nums[i]; } for (int j = 0;
		 * j < n-1; j++) { if (nums[j] > nums[j + 1]) { int temp = 0; temp = nums[j];
		 * nums[j] = nums[j + 1]; nums[j + 1] = temp; } }
		 */
		for (int num : resarr) {
			System.out.print(num + " ");
		}

		return resarr;
	}

	public static void main(String[] args) {
		int[] input = { -4, -1, 0, 3, 10 };
		sortedSquares(input);
		//System.out.println(result);
	}
}
