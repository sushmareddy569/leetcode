package practice;

//1299 - Replace Elements with Greatest Element on Right Side

public class ReplaceElementsWithGreatestElementOnRightSide {
	public int[] replaceElements(int[] arr) {
		int n = arr.length;
		int max = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			int temp = arr[i];
			arr[i] = max;
			max = Math.max(max, temp);
		}
		arr[n-1] = -1;
		return arr;
	}

	public static void main(String[] args) {
		ReplaceElementsWithGreatestElementOnRightSide r = new ReplaceElementsWithGreatestElementOnRightSide();
		int[] input = { 17, 18, 5, 4, 6, 1 };
		int[] result = r.replaceElements(input);
		for (int n : result) {
			System.out.println(n + " ");
		}

	}
}
