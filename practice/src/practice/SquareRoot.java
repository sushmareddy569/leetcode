package practice;

//69 - Sqrt(x)

public class SquareRoot {
	public int mySqrt(int x) {
		if (x < 2) {
			return x;
		}
		long result;
		int low = 2, high = x / 2;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			result = (long) mid * mid;
			if (x < result) {
				high = mid - 1;
			} else if (x > result) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return high;

	}

	public static void main(String[] args) {
		SquareRoot s = new SquareRoot();
		int input = 20;
		int result = s.mySqrt(input);
		System.out.println(result);
	}
}
