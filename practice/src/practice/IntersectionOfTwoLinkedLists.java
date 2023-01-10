package practice;

//160 - Intersection of Two Linked Lists

public class IntersectionOfTwoLinkedLists {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		// the idea is to go behind the other list when it reaches it's end
		// See first comment for visualization under
		// https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
		ListNode a = headA, b = headB;
		while (a != b) {
			if (a != null) {
				a = a.next;
			} else {
				a = headB;
			}
			if (b != null) {
				b = b.next;
			} else {
				b = headA;
			}
		}
		return a;
	}
}
