package practice;

import java.util.HashMap;

//219 - Contains Duplicate II

public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int current = nums[i];
			if (map.containsKey(current) && i - map.get(current) <= k) {
				return true;
			}
			map.put(current, i);
		}
		return false;
	}
	
	public static void main(String[] args) {
		ContainsDuplicateII c = new ContainsDuplicateII();
		boolean result = c.containsNearbyDuplicate(new int[] {1, 2, 3}, 2);
		System.out.println(result);
	}
}
