package practice;

import java.util.ArrayList;
import java.util.List;

//78 - Subsets

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		for (int num : nums) {
			int size = result.size();
			for (int i = 0; i < size; i++) {
				List<Integer> subList = new ArrayList<>(result.get(i));
				subList.add(num);
				result.add(subList);
			}
		}
		return result;
	}

	public List<List<Integer>> subsets1(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result, new ArrayList<>(), nums, 0);
		return result;
	}

	private void backtrack(List<List<Integer>> result, ArrayList<Integer> temp, int[] nums, int start) {

		result.add(new ArrayList<>(temp));
		System.out.println(result);

		for (int i = start; i < nums.length; i++) {

			temp.add(nums[i]);
			backtrack(result, temp, nums, i + 1);
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] args) {
		Subsets s = new Subsets();
		int[] input = { 1, 2, 3 };
		System.out.println(s.subsets1(input));
	}
}
