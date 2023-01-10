package practice;

//414 - Third Maximum Number

import java.util.HashSet;
import java.util.Set;

public class ThirdMaximumNumber {
	public int thirdMax(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		int currentMinInSet = Integer.MAX_VALUE;
		int k = 3;
		for (int num : nums) {
			if (!set.contains(num)) {
				set.add(num);
				if (set.size() > k) {
					currentMinInSet = findMinInSet(set);
					set.remove(currentMinInSet);
				}
			}
		}
		if (set.size() < k) {
			int max = Integer.MIN_VALUE;
			for (int num : set) {
				max = num > max ? num : max;
			}
			return max;
		}
		return findMinInSet(set);
	}

	private int findMinInSet(Set<Integer> set) {
		int currentMin = Integer.MAX_VALUE;
		for (int num : set) {
			currentMin = num < currentMin ? num : currentMin;
		}
		return currentMin;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 4, 4, 6 };
		ThirdMaximumNumber th = new ThirdMaximumNumber();
		int result = th.thirdMax(nums);
		System.out.println(result);
	}

}
