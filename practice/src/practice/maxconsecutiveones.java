package practice;

//485 - Max Consecutive Ones

public class maxconsecutiveones {

	public int findMaxConsecutiveOnes(int[] nums) {
		int count = 0;
		int temp = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				count++;
			} else {
				count = 0;
			}

			temp = Math.max(temp, count);
		}
		return temp;
	}

	public static void main(String[] args) {
		maxconsecutiveones max = new maxconsecutiveones();

		int[] input = { 1, 1, 0, 1, 1, 1 };
		int result = max.findMaxConsecutiveOnes(input);

		System.out.println(result);
	}
}
