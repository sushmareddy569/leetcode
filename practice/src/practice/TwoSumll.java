package practice;

//167 - Two Sum II - Input array is sorted 

public class TwoSumll {
	public int[] twoSum(int[] numbers, int target) {
		int start = 0, end = numbers.length - 1;
		while (start < end) {
			int sum = numbers[start] + numbers[end];
			if (sum == target) {
				return new int[] { start + 1, end + 1 };
			} else if (sum > target) {
				end = largestSmallerOrLastEqual(numbers, start, end, target - numbers[start]);
			} else {
				start = smallestLargerOrFirstEqual(numbers, start, end, target - numbers[end]);
			}
		}
		return new int[2];
	}

	private int largestSmallerOrLastEqual(int[] numbers, int start, int end, int target) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (numbers[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}

	private int smallestLargerOrFirstEqual(int[] numbers, int start, int end, int target) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (numbers[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		TwoSumll t = new TwoSumll();
		int[] input1 = { 2, 7, 11, 15 };
		int val = 9;
		int[] result = t.twoSum(input1, val);
		for (int n : result) {
			System.out.println(n + " ");
		}
	}

}
