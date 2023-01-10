package practice;

//162 - Find Peak Element

public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		int n = nums.length;
		if (n == 1) {
			return 0;
		}
		if (nums[0] > nums[1]) {
			return 0;
		}
		if (nums[n - 1] > nums[n - 2]) {
			return n - 1;
		}
		int low = 0, high = n - 2;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
				return mid;
			} else if (mid > 0 && nums[mid] < nums[mid - 1]) {
				high = mid - 1;
			} else if (mid < n - 1 && nums[mid] < nums[mid + 1]) {
				low = mid + 1;
			}
		}
		return -1;
	}

	public int findPeakElement1(int[] nums) {
		if (nums.length == 1)
			return 0;

		int n = nums.length;

		if (nums[0] > nums[1])
			return 0;
		if (nums[n - 1] > nums[n - 2])
			return n - 1;

		int start = 1;
		int end = n - 2;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
				return mid;
			else if (nums[mid] < nums[mid - 1])
				end = mid - 1;
			else if (nums[mid] < nums[mid + 1])
				start = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		FindPeakElement f = new FindPeakElement();
		int[] input = { 1, 2, 1, 3, 5, 6, 4 };
		int result = f.findPeakElement(input);
		System.out.println(result);
	}
}
