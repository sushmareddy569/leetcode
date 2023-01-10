package practice;

import java.util.HashSet;
import java.util.Set;

//287 - Find the Duplicate Number

public class FindTheDuplicateNumber {
	//Time complexity : O(nlogn)
	public int findDuplicate1(int[] nums) {
		int low = 1, high = nums.length - 1;
		int duplicate = -1;

		while (low <= high) {
			int cur = (low + high) / 2;

			int count = 0;
			for (int num : nums) {
				if (num <= cur)
					count++;
			}

			if (count > cur) {
				duplicate = cur;
				high = cur - 1;
			} else {
				low = cur + 1;
			}
		}
		return duplicate;
	}
	// Time complexity : O(n)
	public int findDuplicate2(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num))
                return num;
            seen.add(num);
        }
        return -1;
    }

	public static void main(String[] args) {
		FindTheDuplicateNumber f = new FindTheDuplicateNumber();
		int[] input = { 1, 3, 4, 5, 6, 8, 7, 9, 2, 2 };
		int result = f.findDuplicate1(input);
		System.out.println(result);
	}
}
