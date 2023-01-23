package practice;

import java.util.ArrayList;
import java.util.List;

// 22 - Generate Parentheses

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		backtrack1(list, "", 0, 0, n);
		return list;
	}

	public void backtrack1(List<String> list, String str, int open, int close, int max) {

		if (str.length() == max * 2) {
			list.add(str);
			return;
		}

		if (open < max) {
			backtrack1(list, str + "(", open + 1, close, max);
		}
		if (open > close) {
			backtrack1(list, str + ")", open, close + 1, max);
		}
	}

	public static void main(String[] args) {
		GenerateParentheses g = new GenerateParentheses();
		System.out.println(g.generateParenthesis(2));
	}
}
