package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// 347 - Top K Frequent Elements

public class TopKFrequentElements {
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int num : nums) {
			countMap.put(num, countMap.getOrDefault(num, 0) + 1);
		}
		// bucket[i] is the list of elements that are of count i
		List<Integer>[] bucket = new List[nums.length + 1];
		for (int key : countMap.keySet()) {
			int count = countMap.get(key);

			if (bucket[count] == null) {
				bucket[count] = new ArrayList<>();
			}
			bucket[count].add(key);
		}

		int[] result = new int[k];
		int resultIndex = 0;

		for (int count = bucket.length - 1; count >= 0; count--) {
			List<Integer> currentBucket = bucket[count];

			if (currentBucket != null) {
				for (int i = 0; i < currentBucket.size() && resultIndex < k; i++) {
					result[resultIndex++] = currentBucket.get(i);
				}
			}
		}
		return result;
	}

	public int[] topKFrequent1(int[] nums, int k) {
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int num : nums) {
			countMap.put(num, countMap.getOrDefault(num, 0) + 1);
		}
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			pq.offer(entry);

			if (pq.size() > k) {
				pq.poll();
			}
		}

		int[] result = new int[k];

		while (!pq.isEmpty()) {
			result[--k] = pq.poll().getKey();
		}
		return result;
	}
}
