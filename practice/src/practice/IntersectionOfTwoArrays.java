package practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//349 - Intersection of Two Arrays

public class IntersectionOfTwoArrays {
	// Time: [sort] + [sizeOfArray1Array2*binarySearch] - O(nlogn) + O(mlogn)
	public int[] intersection1(int[] nums1, int[] nums2) {
		Arrays.sort(nums2);
		Set<Integer> resultSet = new HashSet<Integer>();
		for (Integer num : nums1) {
			if (binarySearch(nums2, num)) {
				resultSet.add(num);
			}
		}

		int[] result = new int[resultSet.size()];
		int i = 0;
		for (Integer num : resultSet) {
			result[i] = num;
			i++;
		}
		return result;
	}

	private boolean binarySearch(int[] nums, Integer target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (target == nums[mid]) {
				return true;
			} else if (target > nums[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}
	// Time: O(nlogn); space: constant
	public int[] intersection2(int[] nums1, int[] nums2) {
		Set<Integer> resultSet = new HashSet<Integer>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int i = 0, j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				resultSet.add(nums1[i]);
				i++;
				j++;
			}
		}
		int[] result = new int[resultSet.size()];
		int k = 0;
		for (Integer num : resultSet) {
			result[k] = num;
			k++;
		}
		return result;
	}

	public static void main(String[] args) {
		IntersectionOfTwoArrays i = new IntersectionOfTwoArrays();
		int[] input1 = { 1, 2, 2, 1 };
		int[] input2 = { 2, 2 };
		int[] result = i.intersection2(input1, input2);
		for (int n : result) {
			System.out.println(n + " ");
		}
	}
}
