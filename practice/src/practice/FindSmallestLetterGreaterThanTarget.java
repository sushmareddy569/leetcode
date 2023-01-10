package practice;

//744 - Find Smallest Letter Greater Than Target

public class FindSmallestLetterGreaterThanTarget {
	public char nextGreatestLetter(char[] letters, char target) {
		if (letters[0] > target) {
			return letters[0];
		}
    	if (letters[letters.length - 1] <= target) {
    		return letters[0];
    	}
		int start = 0, end = letters.length-1;

		while (start < end) {
			int mid = start + (end - start) / 2;

			if (letters[mid] <= target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return letters[start];
	}

	public static void main(String[] args) {
		FindSmallestLetterGreaterThanTarget f = new FindSmallestLetterGreaterThanTarget();
		char[] input = { 'c', 'f', 'j' };
		char val = 'a';
		char result = f.nextGreatestLetter(input, val);
		System.out.println(result);
	}
}
