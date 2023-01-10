package practice;

//142 - Linked List Cycle II

public class LinkedListCycleII {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				ListNode slow2 = head;
				while (slow2 != slow) {
					slow = slow.next;
					slow2 = slow2.next;
				}
				return slow;
			}
		}
		return null;
	}
}
