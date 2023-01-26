package practice;

import java.util.Arrays;
import java.util.PriorityQueue;

// 215 - Kth Largest Element in an Array

public class KthLargestElementInAnArray {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int num : nums) {
			pq.offer(num);
		}
		while (pq.size() > k) {
			pq.poll();
		}
		return pq.peek();
	}

	public int findKthLargest1(int[] nums, int k) {
		int n = nums.length;
		Arrays.sort(nums);
		return nums[n - k];
	}

	public int findKthLargest2(int[] nums, int k) {
		int left = 0;
		int right = nums.length - 1;

		while (true) {
			int pos = partition(nums, left, right);

			if (pos == k - 1) {
				return nums[pos];
			} else if (pos > k - 1) {
				right = pos - 1;
			} else {
				left = pos + 1;
			}
		}
	}

	private int partition(int[] nums, int left, int right) {

		int pivot = nums[right];
		int pIndex = left;

		for (int i = left; i < right; i++) {
			if (nums[i] >= pivot) {
				swap(nums, pIndex, i);
				pIndex++;
			}
		}
		swap(nums, pIndex, right);
		return pIndex;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		KthLargestElementInAnArray k = new KthLargestElementInAnArray();
		int[] arr = new int[] { 3, 2, 1, 5, 6, 4 };
		int m = 2;
		System.out.println(k.findKthLargest2(arr, m));

	}
}
