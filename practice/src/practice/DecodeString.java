package practice;

import java.util.Stack;

//394 - Decode String

public class DecodeString {
	public String decodeString(String s) {
		Stack<Integer> intStack = new Stack<Integer>();
		Stack<String> charStack = new Stack<String>();
		String result = "";
		int index = 0;

		while (index < s.length()) {
			if (Character.isDigit(s.charAt(index))) {
				int count = 0;
				while (Character.isDigit(s.charAt(index))) {
					count = 10 * count + (s.charAt(index) - '0');
					index++;
				}
				intStack.push(count);
			} else if (s.charAt(index) == '[') {
				charStack.push(result);
				result = "";
				index++;
			} else if (s.charAt(index) == ']') {
				StringBuilder temp = new StringBuilder(charStack.pop());
				int count = intStack.pop();
				for (int i = 0; i < count; i++) {
					temp.append(result);
				}
				result = temp.toString();
				index++;
			} else {
				result = result + s.charAt(index);
				index++;
			}
		}
		return result;
	}
}
