package practice;

import java.util.PriorityQueue;

// 1046 - Last Stone Weight

public class LastStoneWeight {
	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for (int num : stones) {
			pq.offer(num);
		}
		while (pq.size() > 1) {
			pq.offer(pq.poll() - pq.poll());
		}
		return pq.poll();
	}
}
