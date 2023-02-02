package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//17 - Letter Combinations of a Phone Number

public class LetterCombinationsOfAPhoneNumber {
	public List<String> letterCombinations(String digits) {
		LinkedList<String> result = new LinkedList<>();
		if (digits.length() == 0) {
			return result;
		}
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		result.add("");

		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));

			while (result.peek().length() == i) {
				String current = result.remove();

				String letters = mapping[x];
				for (char c : letters.toCharArray()) {
					result.add(current + c);
				}
			}
		}
		return result;
	}

	public List<String> letterCombinations1(String digits) {
		List<String> result = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			return result;
		}
		backtrack(digits, new StringBuilder(), result, 0);
		return result;
	}

	private void backtrack(String digits, StringBuilder sb, List<String> result, int index) {
		if (index == digits.length()) {
			result.add(sb.toString());
			return;
		}
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		String letters = mapping[Character.getNumericValue(digits.charAt(index))];

		for (char ch : letters.toCharArray()) {
			sb.append(ch);
			backtrack(digits, sb, result, index + 1);
			sb.setLength(sb.length() - 1);
		}
	}
}
