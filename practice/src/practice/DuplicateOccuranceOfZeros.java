package practice;

//1089 - Duplicate Zeros

public class DuplicateOccuranceOfZeros {
	public static void duplicateZeros(int[] arr) {
		// int[] resarr = new int[arr.length];
		int n = arr.length;
		int countOfZeroes = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				countOfZeroes++;
			}
		}
		int len = n + countOfZeroes;
		for (int i = n - 1, j = len - 1; i >= 0 && j >= 0; i--, j--) {
			if (arr[i] != 0) {
				if (j < n) {
					arr[j] = arr[i];
				}
			} else {
				if (j < n) {
					arr[j] = arr[i];
				}
				j--;
				if (j < n) {
					arr[j] = arr[i];
				}
			}
		}

		for (int num : arr) {
			System.out.print(num + " ");
		}
		/*
		 * while (len < 0) { if (arr[len] != 0) { arr[n - 1] = arr[len]; len--; n--; }
		 * else { arr[n - 1] = 0; arr[n - 2] = 0; n = n - 2; i--; } }
		 */
	}

	public static void main(String[] args) {
		int[] input = { 1, 0, 2, 3, 0, 4, 5, 0 };
		duplicateZeros(input);
	}
}
