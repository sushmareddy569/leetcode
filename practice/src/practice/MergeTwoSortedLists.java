package practice;

//21 - Merge Two Sorted Lists

public class MergeTwoSortedLists {
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

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		ListNode newHead = new ListNode(0);
		ListNode handler = newHead;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				handler.next = list1;
				list1 = list1.next;
			} else {
				handler.next = list2;
				list2 = list2.next;
			}
			handler = handler.next;
		}

		if (list1 != null) {
			handler.next = list1;

		} else if (list2 != null) {
			handler.next = list2;

		}
		return newHead.next;
	}
}
