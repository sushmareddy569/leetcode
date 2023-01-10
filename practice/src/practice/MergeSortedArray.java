package practice;

//88 - Merge Sorted Array

public class MergeSortedArray {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		if (n == 0) {
			for (int n1 : nums1) {
				System.out.print(n1);
			}
			return;
		}

		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] <= nums2[j]) {
				nums1[k] = nums2[j];
				j--;
				k--;
			} else {
				nums1[k] = nums1[i];
				i--;
				k--;
			}
		}

		while (i >= 0) {
			nums1[k] = nums1[i];
			k--;
			i--;
		}

		while (j >= 0) {
			nums1[k] = nums2[j];
			k--;
			j--;
		}

		for (int n1 : nums1) {
			System.out.print(n1 + " ");
		}
	}

	public static void main(String[] args) {
		int[] arr1 = { 5, 6, 0, 0 };
		int[] arr2 = { 1, 2 };
		int m = 2, n = 2;
		merge(arr1, m, arr2, n);

	}

}
