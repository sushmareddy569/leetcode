package practice;

//704 - Binary Search

public class BinarySearch {
	public int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		BinarySearch b = new BinarySearch();
		int[] input = { -1, 0, 3, 5, 9, 12, 15, 18, 20 };
		int val = 0;
		int result = b.search(input, val);
		System.out.println(result);
	}
}
