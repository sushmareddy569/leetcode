package practice;

//430 - Flatten a Multilevel Doubly Linked List

public class FlattenAMultilevelDoublyLinkedList {
	class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;
	};

	public Node flatten(Node head) {
		if (head == null) {
			return null;
		}
		Node node = head;
		while (node != null) {
			if (node.child == null) {
				node = node.next;
			} else {
				Node child = node.child;
				while (child.next != null) {
					child = child.next;
				}
				child.next = node.next;
				if (node.next != null) {
					node.next.prev = child;
				}
				node.next = child.next;
				node.next.prev = node;
				node.child = null;
			}
		}
		return head;
	}

}
