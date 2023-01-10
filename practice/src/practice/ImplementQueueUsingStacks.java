package practice;

import java.util.Stack;

//232 - Implement Queue using Stacks

public class ImplementQueueUsingStacks {
	Stack<Integer> s1 = new Stack<Integer>(); // push stack
	Stack<Integer> s2 = new Stack<Integer>(); // pop stack

	public ImplementQueueUsingStacks() {

	}

	public void push(int x) {
		s1.push(x);
	}

	public void convertS1toS2() {
		int size = s1.size();
		for (int i = 0; i < size; i++) {
			Integer top = s1.pop();
			s2.push(top);
		}
	}

	public int pop() {
		if (s2.isEmpty()) {
			convertS1toS2();
		}
		return s2.pop();
	}

	public int peek() {
		if (s2.isEmpty()) {
			convertS1toS2();
		}
		return s2.peek();
	}

	public boolean empty() {
		return s1.isEmpty() && s2.isEmpty();
	}
}
