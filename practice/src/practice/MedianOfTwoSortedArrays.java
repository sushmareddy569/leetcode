package practice;

//4 - Median of Two Sorted Arrays

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int x = nums1.length;
		int y = nums2.length;

		// if x is greater than y then we need to swap nums1 with nums2 and nums2 with
		// nums1
		// because the time complexity is O(log(min(x,y))
		if (x > y) {
			return findMedianSortedArrays(nums2, nums1);
		}

		int low = 0;
		int high = x;

		while (low <= high) {
			int partitionX = (low + high) / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;

			// if partitionX is 0, it means nothing is on the left side so use -INF
			// if partitionX is length of the input, it means nothing is on the right side
			// so use +INF
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if ((x + y) % 2 == 0) {
					return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				} else {
					return (double) Math.max(maxLeftX, maxLeftY);
				}
			} else if (maxLeftX > minRightY) {
				// we are too far on right side, go to left side for partitionX
				high = partitionX - 1;
			} else {
				// we are too far on left side for partitionX, go on right side.
				low = partitionX + 1;
			}
		}
		// Only we we can come here is if input arrays were not sorted.
		throw new IllegalArgumentException();
	}

	public static void main(String[] args) {
		MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
		int[] input1 = { 1, 3, 5, 7 };
		int[] input2 = { 2, 4, 5, 6 };
		double result = m.findMedianSortedArrays(input1, input2);
		System.out.println(result);
	}
}
