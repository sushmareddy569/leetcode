package practice;

import java.util.HashSet;
import java.util.Set;

//217 -  Contains Duplicate

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i : nums) {
			if (set.contains(i)) {
				return true;
			}
			set.add(i);
		}
		return false;
	}
}
