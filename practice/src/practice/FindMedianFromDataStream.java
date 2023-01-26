package practice;

import java.util.Collections;
import java.util.PriorityQueue;

// 295 - Find Median from Data Stream

public class FindMedianFromDataStream {
	private PriorityQueue<Integer> large = new PriorityQueue<>(Collections.reverseOrder()); // max-heap
	private PriorityQueue<Integer> small = new PriorityQueue<>(); // min-heap
	private boolean even = true;

	public FindMedianFromDataStream() {
	}

	public void addNum(int num) {
		if (even) {
			small.offer(num);
			large.offer(small.poll());
		} else {
			large.offer(num);
			small.offer(large.poll());
		}
		even = !even;
	}

	public double findMedian() {
		if (even) {
			return (large.peek() + small.peek()) / 2.0;
		} else {
			return large.peek();
		}
	}

	public static void main(String[] args) {
		FindMedianFromDataStream m = new FindMedianFromDataStream();
		m.addNum(1);
		// Small: []; Large: [1]
		m.addNum(2);
		// Small: [2]; Large: [1]

		System.out.println(m.findMedian()); // 1.5

		m.addNum(5);
		// Small: [5]; Large: [2, 1]
		System.out.println(m.findMedian()); // 2.0

		m.addNum(3);
		// Small: [3, 5]; Large: [2, 1]
		System.out.println(m.findMedian()); // 2.5
	}
}
