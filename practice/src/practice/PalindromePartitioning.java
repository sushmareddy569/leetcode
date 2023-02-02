package practice;

import java.util.ArrayList;
import java.util.List;

//131 - Palindrome Partitioning

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		backtrack(result, new ArrayList<>(), s, 0);
		return result;
	}

	private void backtrack(List<List<String>> result, ArrayList<String> temp, String s, int start) {
		if (start == s.length()) {
			result.add(new ArrayList<>(temp));
			return;
		}
		for (int i = start; i < s.length(); i++) {
			if (isPalindrome(s, start, i)) {
				temp.add(s.substring(start, i + 1));
				backtrack(result, temp, s, i + 1);
				temp.remove(temp.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s, int low, int high) {
		while (low < high) {
			if (s.charAt(low) != s.charAt(high)) {
				return false;
			}
			low++;
			high--;
		}
		return true;
	}
}
