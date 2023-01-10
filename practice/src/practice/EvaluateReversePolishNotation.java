package practice;

import java.util.Stack;

//150 - Evaluate Reverse Polish Notation

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();

		for (String token : tokens) {
			if (!stack.isEmpty() && isOperand(token)) {

				int num1 = stack.pop();
				int num2 = stack.pop();
				int result = 0;

				if (token.equals("+")) {
					result = num2 + num1;
				} else if (token.equals("-")) {
					result = num2 - num1;
				} else if (token.equals("*")) {
					result = num2 * num1;
				} else if (token.equals("/")) {
					result = num2 / num1;
				}
				stack.push(result);
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.peek();
	}

	private boolean isOperand(String token) {
		return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
	}
}
