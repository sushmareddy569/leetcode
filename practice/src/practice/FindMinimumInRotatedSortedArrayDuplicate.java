package practice;

//154 - Find Minimum in Rotated Sorted Array II

public class FindMinimumInRotatedSortedArrayDuplicate {
	public int findMin(int[] nums) {
		int n = nums.length;
		int start = 0;
		int end = n - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] > nums[end]) {
				start = mid + 1;
			} else if (nums[mid] < nums[end]) {
				end = mid;
			} else {
				end = end - 1;
			}
		}

		return nums[start];
	}

	public static void main(String[] args) {
		FindMinimumInRotatedSortedArrayDuplicate f = new FindMinimumInRotatedSortedArrayDuplicate();
		int[] input = { 4, 5, 0, 0, 1, 1 };
		int result = f.findMin(input);
		System.out.println(result);
	}
}
