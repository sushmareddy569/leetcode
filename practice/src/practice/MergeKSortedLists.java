package practice;

// 23 - Merge K Sorted Lists

public class MergeKSortedLists {
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

	public ListNode mergeKLists(ListNode[] lists) {
		return mergedLists(lists, 0, lists.length - 1);

	}

	public ListNode mergedLists(ListNode[] lists, int l, int r) {
		if (r < l) {
			return null;
		}
		if (l == r) {
			return lists[r];
		}
		int mid = (l + r) / 2;

		ListNode l1 = mergedLists(lists, l, mid);
		ListNode l2 = mergedLists(lists, mid + 1, r);
		return mergeTwoLists(l1, l2);
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode newHead = new ListNode(0);
		ListNode current = newHead;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}
		if (l1 != null) {
			current.next = l1;
		} else if (l2 != null) {
			current.next = l2;
		}
		return newHead.next;
	}

}
