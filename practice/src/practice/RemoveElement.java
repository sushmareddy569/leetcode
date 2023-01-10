package practice;

//27 - Remove Element

public class RemoveElement {
	public int[] removeElement(int[] nums, int val) {
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}
		}
		System.out.println(i);
		for (int a = 0; a < i; a++) {
			System.out.println(nums[a]);

		}
		return nums;

	}

	public static void main(String[] args) {
		RemoveElement r = new RemoveElement();
		int[] input = { 0, 4, 4, 0, 4, 4, 4, 0, 2 };
		int check = 4;
		// int[] result =
		r.removeElement(input, check);
		/*
		 * for (int n : result) { System.out.println(n + " "); }
		 */
		// System.out.println(result);
	}
}
