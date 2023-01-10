package practice;

//33 - Search in Rotated Sorted Array

public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {

		int start = 0, end = nums.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			}

			if (nums[mid] <= nums[end]) {

				if (target >= nums[mid] && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else {

				if (target >= nums[start] && target <= nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
		int[] input = { 4, 5, 6, 7, 0, 1, 2 };
		int val = 0;
		int result = s.search(input, val);
		System.out.println(result);
	}
}
