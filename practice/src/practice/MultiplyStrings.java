package practice;

//43 - Multiply Strings

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1 == null || num2 == null) {
			throw new IllegalArgumentException("Input numbers are invalid");
		}
		int m = num1.length();
		int n = num2.length();

		if (m == 0 || n == 0 || "0".equals(num1) || "0".equals(num2)) {
			return "0";
		}
		if ("1".equals(num1)) {
			return num2;
		}
		if ("1".equals(num2)) {
			return num1;
		}

		int[] result = new int[m + n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int d1 = num1.charAt(i) - '0';
				int d2 = num2.charAt(j) - '0';
				int product = d1 * d2;

				product = product + result[i + j + 1];
				result[i + j + 1] = product % 10;
				result[i + j] = result[i + j] + product / 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int r : result) {
			if (sb.length() == 0 && r == 0) {
				continue;
			}
			sb.append(r);
		}
		return sb.toString();
	}

	public String multiply1(String num1, String num2) {
		if (num1 == null || num2 == null) {
			throw new IllegalArgumentException("Input numbers are invalid");
		}
		int m = num1.length();
		int n = num2.length();

		if (m == 0 || n == 0 || "0".equals(num1) || "0".equals(num2)) {
			return "0";
		}
		if ("1".equals(num1)) {
			return num2;
		}
		if ("1".equals(num2)) {
			return num1;
		}

		int[] result = new int[m + n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int d1 = num1.charAt(i) - '0';
				int d2 = num2.charAt(j) - '0';
				int product = d1 * d2;
				result[i + j + 1] = result[i + j + 1] + product;
			}
		}
		int carry = 0;
		for (int i = result.length - 1; i >= 0; i--) {
			int temp = (result[i] + carry) % 10;
			carry = (result[i] + carry) / 10;
			result[i] = temp;
		}
		StringBuilder sb = new StringBuilder();
		for (int r : result) {
			if (sb.length() == 0 && r == 0) {
				continue;
			}
			sb.append(r);
		}
		return sb.toString();
	}
}
