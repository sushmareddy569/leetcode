package practice;

import java.util.Stack;

// 20 - Valid Parentheses

public class ValidParentheses {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();

		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				stack.push(')');
			} else if (ch == '{') {
				stack.push('}');
			} else if (ch == '[') {
				stack.push(']');
			} else if (stack.isEmpty() || stack.pop() != ch) {
				return false;
			}
		}
		return stack.isEmpty();
	}
}
