package practice;

//941 - Valid Mountain Array

public class ValidMountainArray {
	public boolean validMountainArray(int[] arr) {
		int n = arr.length;
		int i = 0;
		int j = n - 1;
		while (i + 1 < n && arr[i] < arr[i + 1]) {
			i++;
		}
		while (j > 0 && arr[j - 1] > arr[j]) {
			j--;
		}
		return i > 0 && i == j && j < n - 1;
	}

	public static void main(String[] args) {
		ValidMountainArray v = new ValidMountainArray();
		int[] input = { 0, 3, 2, 1 };
		boolean result = v.validMountainArray(input);
		System.out.println(result);

	}
}
