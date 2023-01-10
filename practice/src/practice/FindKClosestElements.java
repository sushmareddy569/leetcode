package practice;

//658 - Find K Closest Elements

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> list = new ArrayList<Integer>();
		int n = arr.length;
		if (k == 0 || n == 0 || k > n) {
			return list;
		}
		int low = 0, high = n - k;
		while (low < high) {
			int mid = low + (high - low) / 2;
			// arr[mid+k] is closer to x than arr[mid]
			if (x - arr[mid] > arr[mid + k] - x) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		for (int i = low; i < low + k; i++) {
			list.add(arr[i]);
		}
		// return Arrays.stream(arr, low, low + k).boxed().collect(Collectors.toList());
		return list;
	}

	public static void main(String[] args) {
		FindKClosestElements f = new FindKClosestElements();
		int[] input = { 1, 2, 3, 4, 5 };
		int val1 = 4;
		int val2 = 3;
		List<Integer> result = f.findClosestElements(input, val1, val2);
		System.out.println(result);
	}
}
