package practice;

//367 - Valid Perfect Square

public class ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
		if (num < 2) {
			return true;
		}

		long low = 2, high = num / 2;

		while (low <= high) {
			long mid = low + (high - low) / 2;

			long sqr = mid * mid;
			if (sqr == num) {
				return true;
			} else if (sqr > num) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ValidPerfectSquare v = new ValidPerfectSquare();
		int val = 16;
		boolean result = v.isPerfectSquare(val);
		System.out.println(result);
	}
}
