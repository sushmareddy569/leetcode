package practice;

//26 - Remove Duplicates from Sorted Array

public class RemoveDuplicatesFromSortedArray {
	public int[] removeDuplicates(int[] nums) {
		if (nums.length <= 1) {
			return nums;
		}
		int i = 1;
		int j = 0;
		for (i = 1; i < nums.length; i++) {
			if (nums[i] != nums[j]) {
				j++;
				nums[j] = nums[i];
			}
		}
		
		int k = j + 1;
		System.out.println(k);
		for(k=j+1; k<=nums.length-1; k++) {
				nums[k]=0;
			}
		return nums;

	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
		int[] input = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int[] result = r.removeDuplicates(input);
		for (int n : result) {
			System.out.println(n + " ");
		}
		// System.out.println(result);
	}
}
