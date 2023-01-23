package practice;

// 74 - Search a 2D Matrix

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		if (matrix == null || m == 0 || n == 0) {
			return false;
		}
		// Finding the row in which target exists
		int start = 0;
		int end = m - 1;
		while (start != end && matrix[end][0] > target) {
			int mid = (start + end + 1) / 2;
			int val = matrix[mid][0];
			if (val < target) {
				start = mid;
			} else if (val > target) {
				end = mid - 1;
			} else {
				return true;
			}
		}
		int row = end;
		// finding the column
		start = 0;
		end = n - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			int val = matrix[row][mid];
			if (val < target) {
				start = mid + 1;
			} else if (val > target) {
				end = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean searchMatrix1(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		if (matrix == null || m == 0 || n == 0) {
			return false;
		}
		int i = 0, j = n - 1;
		while (i < m && j >= 0) {
			if (matrix[i][j] == target) {
				return true;
			} else if (matrix[i][j] > target) {
				j--;
			} else {
				i++;
			}
		}
		return false;
	}
}
