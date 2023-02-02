package practice;

// 371 - Sum of Two Integers

public class SumOfTwoIntegers {
	public int getSum(int a, int b) {
		if (a == 0) {
			return b;
		}
		if (b == 0) {
			return a;
		}

		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}

		return a;
	}

	public int getSum1(int a, int b) {
		return (b == 0) ? a : getSum1(a ^ b, (a & b) << 1);
	}

	public static void main(String[] args) {
		int a = 2;
		int b = 3;
		SumOfTwoIntegers s = new SumOfTwoIntegers();
		System.out.println(s.getSum(a, b));
	}
}
