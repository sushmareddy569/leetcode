package practice;

import java.util.HashSet;
import java.util.Set;

// 128 -  Longest Consecutive Sequence

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int max = 0;

		for (int num : nums) {
			set.add(num);
		}

		for (int num : nums) {
			int count = 1;

			if (!set.contains(num - 1)) { // only check for one direction
				while (set.contains(num + count)) {
					count++;
				}
				max = Math.max(max, count);
			}
		}

		return max;
	}

	public static void main(String[] args) {
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();

		System.out.println(lcs.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
	}
}
