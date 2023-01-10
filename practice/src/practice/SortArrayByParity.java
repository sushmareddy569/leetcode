package practice;

//905 - Sort Array By Parity

public class SortArrayByParity {
	public int[] sortArrayByParity(int[] nums) {
		for (int i = 0, j = 0; j < nums.length; j++)
			if (nums[j] % 2 == 0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
			}
		return nums;
	}

	public static void main(String[] args) {
		SortArrayByParity s = new SortArrayByParity();
		int[] input = { 3, 1, 2, 4 };
		int[] result = s.sortArrayByParity(input);
		for (int n : result) {
			System.out.println(n + " ");
		}
		// System.out.println(result);
	}
}
