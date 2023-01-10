package practice;

// 125 - Valid Palindrome

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		s = s.replaceAll("[^a-zA-z0-9]", "").toLowerCase();
		int start = 0;
		int end = s.length();
		while (start < end) {
			if (s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean isPalindrome1(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		int head = 0;
		int tail = s.length() - 1;

		while (head < tail) {
			char cHead = s.charAt(head);
			char cTail = s.charAt(tail);

			if (!Character.isLetterOrDigit(cHead)) {
				head++;
			} else if (!Character.isLetterOrDigit(cTail)) {
				tail--;
			} else {
				if (Character.toLowerCase(cHead) == Character.toLowerCase(cTail)) {
					head++;
					tail--;
				} else {
					return false;
				}
			}
		}
		return true;
	}
}
