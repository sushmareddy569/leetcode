package practice;

//283 - Move Zeroes

public class MoveZeroes {
	/*public void moveZeroes(int[] nums) {
		int i = 0;
		int n = nums.length;
		while (i < n ) {
			if (nums[i] == 0) {
				int j = i + 1;
				while (j < n  && nums[j] != 0) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
			i++;
		}
	}*/

	public void moveZeroes1(int[] nums) {
		int l = 0;
		for (int r = 0; r < nums.length; r++) {
			if (nums[r] != 0) {
				nums[l] = nums[r];
				l++;
			}
		}
		while (l < nums.length) {
			nums[l] = 0;
			l++;
		}
		for (int num : nums) {
			System.out.println(num +  " ");
		}

	}

	public static void main(String[] args) {
		MoveZeroes m = new MoveZeroes();
		int[] input = { 1, 2, 0, 0, 0, 3, 0, 5 };
		m.moveZeroes1(input);
	}
}
