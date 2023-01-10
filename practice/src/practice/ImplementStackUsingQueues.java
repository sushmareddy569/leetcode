package practice;

import java.util.LinkedList;
import java.util.Queue;

//225 - Implement Stack using Queues 

public class ImplementStackUsingQueues {
	Queue<Integer> q = new LinkedList<Integer>();

	public ImplementStackUsingQueues() {

	}

	public void push(int x) {
		q.add(x);
		int k = q.size();
		for (int i = 0; i < k - 1; i++) {
			Integer first = q.remove();
			q.add(first);
		}
	}

	public int pop() {
		return q.remove();
	}

	public int top() {
		return q.peek();
	}

	public boolean empty() {
		return q.isEmpty();
	}
}
