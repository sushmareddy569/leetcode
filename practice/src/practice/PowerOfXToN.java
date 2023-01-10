package practice;

//50 - Pow(x, n)

public class PowerOfXToN {
	public double myPow(double x, int n) {
		long N = n;
		if (N < 0) {
			x = 1 / x;
			N = -N;
		}

		return fastPow(x, N);
	}

	private double fastPow(double x, long n) {
		if (n == 0) {
			return 1.0;
		}

		double half = fastPow(x, n / 2);
		if (n % 2 == 0) {
			return half * half;
		} else {
			return half * half * x;
		}
	}

	public static void main(String[] args) {
		PowerOfXToN p = new PowerOfXToN();
		double input = 2.00000;
		int val = 10;
		double result = p.myPow(input, val);
		System.out.println(result);
	}
}
