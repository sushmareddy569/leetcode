package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 3 - Longest Substring Without Repeating Characters

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int maxLength = 0;
		int left = 0;
		int right = 0;
		Set<Character> set = new HashSet<>();

		while (right < s.length()) {
			Character rightch = s.charAt(right);

			if (!set.contains(rightch)) {
				set.add(rightch);
				right++;
			} else {
				Character leftch = s.charAt(left);
				set.remove(leftch);
				left++;
			}
			maxLength = Math.max(maxLength, set.size());
		}
		return maxLength;
	}

	public int lengthOfLongestSubstring1(String s) {
		int maxLength = 0;
		int left = 0;
		int right = 0;
		Map<Character, Integer> map = new HashMap<>();

		for (right = 0; right < s.length(); right++) {
			Character rightch = s.charAt(right);
			if (map.containsKey(rightch)) {
				left = Math.max(left, map.get(rightch) + 1);
			}
			map.put(rightch, right);
			maxLength = Math.max(maxLength, right - left + 1);
		}
		return maxLength;
	}

	public int lengthOfLongestSubstring2(String s) {
		int[] map = new int[128];
		int left = 0, right = 0;
		int maxLength = 0;

		while (right < s.length()) {
			Character rightCh = s.charAt(right);

			if (map[rightCh] == 0) {
				maxLength = Math.max(maxLength, right - left + 1);
			}

			map[rightCh]++;
			right++;

			// Checking the next letter here as right is incremented right above
			while (right < s.length() && map[s.charAt(right)] > 0) {
				Character leftCh = s.charAt(left);
				map[leftCh]--;
				left++;
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
		String s = "abcabcbb";
		System.out.println(l.lengthOfLongestSubstring2(s));
	}
}
