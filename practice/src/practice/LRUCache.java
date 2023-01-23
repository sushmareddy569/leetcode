package practice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// 146 - LRU Cache

public class LRUCache {
	class LRU {
		Map<Integer, Node> map = new HashMap<>();
		Node head = new Node(0, 0); // dummy node
		Node tail = new Node(0, 0); // dummy node
		int capacity;

		public LRU(int capacity) {
			this.capacity = capacity;
			head.next = tail;
			tail.prev = head;
		}

		public int get(int key) {
			Node node = map.get(key);
			if (node == null) {
				return -1;
			}
			remove(node);
			insert(node);
			return node.value;
		}

		public void put(int key, int value) {
			if (map.containsKey(key)) {
				remove(map.get(key));
			}
			if (map.size() == capacity) {
				remove(tail.prev);
			}
			insert(new Node(key, value));
		}

		private void insert(Node node) {
			map.put(node.key, node);

			Node headNext = head.next;
			head.next = node;
			node.prev = head;

			node.next = headNext;
			headNext.prev = node;
		}

		private void remove(Node node) {
			map.remove(node.key);

			Node prev = node.prev;
			Node next = node.next;

			prev.next = next;
			next.prev = prev;
		}

		class Node {
			int key, value;
			Node prev, next;

			Node(int key, int value) {
				this.key = key;
				this.value = value;
			}
		}
	}

	class LRUCacheLinkedHashMap {
		LinkedHashMap<Integer, Integer> map;
		int capacity;

		public LRUCacheLinkedHashMap(int capacity) {
			this.capacity = capacity;
			map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
				protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
					return size() > capacity;
				}
			};
		}

		public int get(int key) {
			return map.getOrDefault(key, -1);
		}

		public void put(int key, int value) {
			map.put(key, value);
		}
	}
}
