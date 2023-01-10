package practice;

//448 - Find All Numbers Disappeared in an Array

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
	}
	
	public List<Integer> findDisappearedNumbers1(int[] nums) {
		List<Integer> result = new ArrayList<>();
		
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			
			if (nums[index] > 0) {
				nums[index] = -nums[index];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				result.add(i + 1);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		FindAllNumbersDisappearedInAnArray fd = new FindAllNumbersDisappearedInAnArray();
		List<Integer> result = fd.findDisappearedNumbers(nums);
		System.out.println(result);
	}
}
