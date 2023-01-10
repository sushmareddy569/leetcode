package practice;

// 143 - Reorder List

public class ReorderList {
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

	public void reorderList(ListNode head) {
		ListNode middleNode = findMiddleNode(head);
		ListNode nextToMid = middleNode.next;
		middleNode.next = null;

		ListNode l2 = reverse(nextToMid);

		ListNode l1 = head;

		while (l1 != null && l2 != null) {
			ListNode next = l1.next;
			l1.next = l2;
			l1 = l2;
			l2 = next;
		}
	}

	private ListNode reverse(ListNode head) {
		ListNode current = head;
		ListNode prev = null;

		while (current != null) {
			ListNode next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;

	}

	private ListNode findMiddleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
