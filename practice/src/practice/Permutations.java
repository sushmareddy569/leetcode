package practice;

import java.util.ArrayList;
import java.util.List;

//46 - Permutations

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result, new ArrayList<>(), nums);
		return result;
	}

	private void backtrack(List<List<Integer>> result, ArrayList<Integer> temp, int[] nums) {
		if (temp.size() == nums.length) {
			result.add(new ArrayList<>(temp));
			return;
		}

		for (int num : nums) {
			if (temp.contains(num)) {
				continue;
			}

			temp.add(num);
			backtrack(result, temp, nums);
			temp.remove(temp.size() - 1);
		}
	}
}
