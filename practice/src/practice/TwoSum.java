package practice;

//1 - Two Sum

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TwoSum {
	public List<Integer> findNumbers(int arr[], int targetsum) {
		List<Integer> reslist = new ArrayList<>();
		Set<Integer> resset = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			resset.add(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {

			int comp = targetsum - arr[i];
			if (resset.contains(comp)) {
				reslist.add(arr[i]);
				reslist.add(comp);
				return reslist;
			}
		}
		return reslist;
	}

	public List<Integer> findNumbers1(int arr[], int targetsum) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> reslist = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {

			int comp = targetsum - arr[i];

			if (map.containsKey(comp)) {
				int index = map.get(comp);
				reslist.add(i);
				reslist.add(index);
				return reslist;
			} else {
				map.put(arr[i], i);
			}
		}

		return reslist;
	}

	public int[] findNumbers2(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[1] = i;
				result[0] = map.get(target - nums[i]);
				return result;
			}
			map.put(nums[i], i);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5 };
		TwoSum two = new TwoSum();

		int[] result = two.findNumbers2(input, 6);
		for (int n : result) {
			System.out.println(n + " ");
		}
		// System.out.println(result);
	}
}
