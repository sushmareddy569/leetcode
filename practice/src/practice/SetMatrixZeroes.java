package practice;

//73 - Set Matrix Zeroes

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		boolean isFirstRow = false;
		boolean isFirstColumn = false;

		int R = matrix.length;
		int C = matrix[0].length;

		for (int i = 0; i < R; i++) {
			if (matrix[i][0] == 0) {
				isFirstRow = true;
				break;
			}
		}
		for (int j = 0; j < C; j++) {
			if (matrix[0][j] == 0) {
				isFirstColumn = true;
				break;
			}
		}
		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		if (isFirstRow) {
			for (int i = 0; i < R; i++) {
				matrix[i][0] = 0;
			}
		}
		if (isFirstColumn) {
			for (int j = 0; j < C; j++) {
				matrix[0][j] = 0;
			}
		}
	}
}
