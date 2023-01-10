package practice;

//2 - Add Two Numbers

public class AddTwoNumbers {
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

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		int sum = 0;
		while (l1 != null || l2 != null) {
			sum = sum / 10;
			if (l1 != null) {
				sum = sum + l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum = sum + l2.val;
				l2 = l2.next;
			}
			ListNode newNode = new ListNode(sum % 10);
			dummy.next = newNode;
			dummy = newNode;
		}
		//if there is a carry
		if(sum/10==1) {
			dummy.next=new ListNode(1);
		}
		return head.next;
	}
}
