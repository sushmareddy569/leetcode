package practice;

//19 - Remove Nth Node From End of List

public class RemoveNthNodeFromEndOfList {
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

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode slow = newHead, fast = newHead;

		for (int i = 0; i < n + 1; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return newHead.next;
	}
}
