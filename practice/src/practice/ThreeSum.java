package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 15 - Three Sum

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> result = new HashSet<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			int low = i + 1;
			int high = nums.length - 1;

			while (low < high) {
				int sum = nums[i] + nums[low] + nums[high];

				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[low], nums[high]));
					low++;
					high--;
				} else if (sum > 0) {
					high--;
				} else {
					low++;
				}
			}
		}
		return new ArrayList<List<Integer>>(result);
	}

	public List<List<Integer>> threeSum1(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int low = i + 1;
				int high = nums.length - 1;

				while (low < high) {
					int sum = nums[i] + nums[low] + nums[high];

					if (sum == 0) {
						result.add(Arrays.asList(nums[i], nums[low], nums[high]));

						while (low < high && nums[low] == nums[low + 1]) {
							low++;
						}
						while (low < high && nums[high] == nums[high - 1]) {
							high--;
						}
						low++;
						high--;
					} else if (sum < 0) {
						low++;
					} else {
						high--;
					}
				}
			}
		}
		return result;
	}
}
