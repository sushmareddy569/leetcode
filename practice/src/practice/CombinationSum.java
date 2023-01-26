package practice;

import java.util.ArrayList;
import java.util.List;

//39 - Combination Sum

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result, new ArrayList<>(), candidates, target, 0);
		return result;
	}

	private void backtrack(List<List<Integer>> result, ArrayList<Integer> temp, int[] candidates, int remain,
			int start) {
		if (remain < 0) {
			return;
		}
		if (remain == 0) {
			result.add(new ArrayList<>(temp));
			return;
		}

		for (int i = start; i < candidates.length; i++) {

			temp.add(candidates[i]);
			backtrack(result, temp, candidates, remain - candidates[i], i);
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] args) {
		CombinationSum c = new CombinationSum();
		int[] input = { 2, 3, 6, 7 };
		int target = 7;
		System.out.println(c.combinationSum(input, target));
	}
}
