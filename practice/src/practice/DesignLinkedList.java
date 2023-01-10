package practice;

//707 - Design Linked List

public class DesignLinkedList {
	int length;
	Node head;

	class Node {
		int val;
		Node next;

		Node(int x) {
			this.val = x;
		}
	}

	public DesignLinkedList() {
		this.length = 0;
		this.head = null;
	}

	public int get(int index) {
		if (index < 0 || index >= length) {
			return -1;
		}
		if (index == 1) {
			return head.val;
		}
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.val;
	}

	public void addAtHead(int val) {
		if (head == null) {
			head = new Node(val);
		} else {
			Node newNode = new Node(val);
			newNode.next = head;
			head = newNode;
		}
		length++;
	}

	public void addAtTail(int val) {
		if (head == null) {
			head = new Node(val);
		} else {
			Node current = head;
			for (int i = 0; i < length - 1; i++) {
				current = current.next;
			}
			current.next = new Node(val);
		}
		length++;
	}

	public void addAtIndex(int index, int val) {
		if (index > length) {
			return;
		}

		if (index <= 0) {
			addAtHead(val);
		} else if (index == length) {
			addAtTail(val);
		} else {
			Node current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			Node newNode = new Node(val);
			newNode.next = current.next;
			current.next = newNode;
			length++;
		}
	}

	public void deleteAtIndex(int index) {
		if (index < 0 || index >= length) {
			return;
		}
		length--;
		if (index == 0) {
			head = head.next;
			return;
		}
		Node current = head;
		for (int i = 0; i < index - 1; i++) {
			current = current.next;
		}
		current.next = current.next.next;
	}
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList(); int param_1 = obj.get(index);
 * obj.addAtHead(val); obj.addAtTail(val); obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
