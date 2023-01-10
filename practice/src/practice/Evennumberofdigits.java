package practice;

//1295 - Find Numbers with Even Number of Digits

//import java.util.ArrayList;
//import java.util.List;

public class Evennumberofdigits {
	public static int findNumbers(int[] nums) {
		int count = 0;
		int result = 0;
		//List<Integer> resList = new ArrayList<>();

		for (int i = 0; i <= nums.length - 1; i++) {
			int current = nums[i];
			count = 0;

			while (current != 0) {
				current = current / 10;
				count++;
			}
			/**
			 * if ((temp > 9 && temp < 100) || (temp > 999 && temp < 10000) || temp ==
			 * 100000) {
			 * 
			 * count++; }
			 */
			if (count % 2 == 0) {
				System.out.println(nums[i]);
				//resList.add(nums[i]);
				result++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] input = { 12, 35, 222, -60, 7896 };
		int result = findNumbers(input);
		System.out.println(result);
	}
}
