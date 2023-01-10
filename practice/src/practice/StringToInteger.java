package practice;

// 8 - String to Integer (atoi)

public class StringToInteger {
	public int myAtoi(String s) {
		int i = 0;
		s = s.trim();
		char[] c = s.toCharArray();

		int sign = 1;
		if (i < c.length && (c[i] == '+' || c[i] == '-')) {
			if (c[i] == '-') {
				sign = -1;
			}
			i++;
		}

		int num = 0;
		int bound = Integer.MAX_VALUE / 10;

		while (i < c.length && c[i] >= '0' && c[i] <= '9') {
			int digit = c[i] - '0';
			// check if the num is equal to bound and if the digit is greater than 7 i.,e
			// Integer.MAX_VALUE % 10
			if (num > bound || (num == bound && digit > 7)) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			num = num * 10 + digit;
			i++;
		}

		return sign * num;
	}
}
