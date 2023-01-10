package practice;

//206 - Reverse Linked List

public class ReverseLinkedList {
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

	public ListNode reverseList(ListNode head) {
		ListNode current = head, previous = null;
		while (current != null) {
			ListNode next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}

	public ListNode reverseList1(ListNode head) {
		return reverseListHelper(head, null);
	}

	private ListNode reverseListHelper(ListNode head, ListNode previous) {
		if (head == null) {
			return previous;
		}
		ListNode current = head;
		ListNode next = current.next;
		current.next = previous;
		previous = head;
		return reverseListHelper(next, head);
	}
}
