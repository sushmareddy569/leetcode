package practice;

//153 - Find Minimum in Rotated Sorted Array

public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		int n = nums.length;
		int start = 0, end = n - 1;

		while (start < end) {
			int mid = start + (end - start) / 2;

			if (nums[mid] > nums[end]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return nums[start];
	}

	public static void main(String[] args) {
		FindMinimumInRotatedSortedArray f = new FindMinimumInRotatedSortedArray();
		int[] input = { 3, 4, 5, 1, 2 };
		int result = f.findMin(input);
		System.out.println(result);
	}
}
