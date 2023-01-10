package practice;

// 48 - Rotate Image

public class RotateImage {
	public void rotate(int[][] matrix) {
		// Reverse the rows of the matrix
		int start = 0;
		int end = matrix.length - 1;

		while (start < end) {
			int[] temp = matrix[start];
			matrix[start] = matrix[end];
			matrix[end] = temp;
			start++;
			end--;
		}
		// Swap the symmetric nodes (i,j) -> (j,i); turning rows to cols
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[0].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	public void rotate1(int[][] matrix) {
		// Transpose of matrix; turns rows into cols and vice versa
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[0].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		// Reverse each row of the image; equivalent to reversing the whole columns
		for (int row = 0; row < matrix.length; row++) {
			int start = 0;
			int end = matrix[row].length - 1;

			while (start < end) {
				int temp = matrix[row][start];
				matrix[row][start] = matrix[row][end];
				matrix[row][end] = temp;
				start++;
				end--;
			}
		}
	}
}
