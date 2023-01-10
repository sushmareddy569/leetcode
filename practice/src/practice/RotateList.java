package practice;

//61 - Rotate List 

public class RotateList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}

		int length = 1;
		ListNode node = head;
		while (node.next != null) {
			node = node.next;
			length++;
		}

		node.next = head;
		k = k % length;

		for (int i = 0; i < length - k; i++) {
			node = node.next;
		}

		head = node.next;
		node.next = null;
		return head;
	}

}
