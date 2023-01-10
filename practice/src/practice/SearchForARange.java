package practice;

//34 - Find First and Last Position of Element in Sorted Array

public class SearchForARange {
	public int[] searchRange(int[] nums, int target) {

		int[] result = new int[2];
		result[0] = findFirst(nums, target);
		result[1] = findLast(nums, target);
		return result;
	}

	private int findFirst(int[] nums, int target) {
		int start = 0, end = nums.length - 1, index = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (target < nums[mid]) {
				end = mid - 1;
			} else if (target > nums[mid]) {
				start = mid + 1;
			} else {
				index = mid;
				end = mid - 1;
			}
		}
		return index;
	}

	private int findLast(int[] nums, int target) {
		int start = 0, end = nums.length - 1, index = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (target < nums[mid]) {
				end = mid - 1;
			} else if (target > nums[mid]) {
				start = mid + 1;
			} else {
				index = mid;
				start = mid + 1;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		SearchForARange s = new SearchForARange();
		int[] input = { 1 };
		int val = 1;
		int[] result = s.searchRange(input, val);
		for (int n : result) {
			System.out.println(n + " ");
		}
	}
}
