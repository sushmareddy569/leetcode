package practice;

public class Implement2DArray {
	public void implementArray(int[][] arr) {
		int row = arr.length;
		int column = arr[0].length;

		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				System.out.println("arr[" + i + "][" + j + "] = " + arr[i][j]);
	}

	public static void main(String[] args) {
		Implement2DArray i = new Implement2DArray();
		int[][] nums = { { 1, 2, 5 }, { 3, 4, 6 } };

		i.implementArray(nums);

	}
}
