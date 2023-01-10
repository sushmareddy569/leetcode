package practice;

//1051 - Height Checker

public class HeightChecker {
	public int heightChecker(int[] heights) {
		int[] countOfHeights = new int[101];
		for (int h : heights) {
			countOfHeights[h] = countOfHeights[h] + 1;
		}

		int result = 0;
		int currentHeightIndex = 0;

		for (int i = 0; i < heights.length; i++) {
			while (countOfHeights[currentHeightIndex] == 0) {
				currentHeightIndex++;
			}

			if (currentHeightIndex != heights[i]) {
				result++;
			}
			countOfHeights[currentHeightIndex]--;
		}

		return result;
	}

	public static void main(String[] args) {
		HeightChecker h = new HeightChecker();
		int[] input = { 1, 1, 4, 2, 1, 3 };
		int result = h.heightChecker(input);
		System.out.println(result);
	}
}
