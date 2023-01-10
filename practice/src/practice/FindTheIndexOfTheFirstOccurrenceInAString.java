package practice;

// 28 - Find the Index of the First Occurrence in a String
// Another Name: Implemnet Strstr

public class FindTheIndexOfTheFirstOccurrenceInAString {
	public int strStr(String haystack, String needle) {
		int l1 = haystack.length();
		int l2 = needle.length();
		if (l1 < l2) {
			return -1;
		} else if (l2 == 0) {
			return 0;
		}

		int threshold = l1 - l2;
		for (int i = 0; i <= threshold; ++i) {
			if (haystack.substring(i, i + l2).equals(needle)) {
				return i;
			}
		}
		return -1;
	}

	public int strStr1(String haystack, String needle) {
		int l1 = haystack.length();
		int l2 = needle.length();
		if (l2 == 0) {
			return 0;
		}

		for (int i = 0; i <= l1 - l2; i++) {
			for (int j = 0; j < l2 && haystack.charAt(i + j) == needle.charAt(j); j++) {
				if (j == l2 - 1) {
					return i;
				}
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		String haystack = "leetcode";
		String needle = "leeto";
		FindTheIndexOfTheFirstOccurrenceInAString f = new FindTheIndexOfTheFirstOccurrenceInAString();
		int result = f.strStr1(haystack, needle);
		System.out.println(result);
	}
}
