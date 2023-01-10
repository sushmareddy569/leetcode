package practice;

// 242 - Valid Anagram

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] charCount = new int[26];
		for (int i = 0; i < s.length(); i++) {
			charCount[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			charCount[t.charAt(i) - 'a']--;
		}
		for (int count : charCount) {
			if (count != 0) {
				return false;
			}
		}
		return true;
	}
}
