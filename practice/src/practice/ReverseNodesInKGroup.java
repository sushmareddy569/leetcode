package practice;

// 25 - Reverse Nodes in k-Group

public class ReverseNodesInKGroup {
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

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode curr = head, newHead = null;
		int count = 0;
		while (curr != null && count != k) { // find the k+1 node
			curr = curr.next;
			count++;
		}
		if (count == k) {
			newHead = reverse(k, head);
			head.next = reverseKGroup(curr, k);
			return newHead;
		}
		return head;

	}

	private ListNode reverse(int count, ListNode head) {
		ListNode p = null;
		while (count-- > 0) { // reverse current k-group:
			ListNode n = head.next;
			head.next = p;
			p = head;
			head = n;
		}
		return p;
	}

	public ListNode reverseKGroup1(ListNode head, int k) {

		ListNode curr = head;
		int count = 0;
		while (curr != null && count != k) { // find the k+1 node
			curr = curr.next;
			count++;
		}
		if (count == k) { // if k+1 node is found
			curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
			// head - head-pointer to direct part,
			// curr - head-pointer to reversed part;
			while (count-- > 0) { // reverse current k-group:
				ListNode tmp = head.next; // tmp - next head in direct part
				head.next = curr; // preappending "direct" head to the reversed
									// list
				curr = head; // move head of reversed part to a new node
				head = tmp; // move "direct" head to the next node in direct
							// part
			}
			head = curr;
		}
		return head;
	}

	public static void main(String[] args) {
		ReverseNodesInKGroup r = new ReverseNodesInKGroup();
		ListNode head = r.new ListNode(1);
		head.next = r.new ListNode(2);
		head.next.next = r.new ListNode(3);
		head.next.next.next = r.new ListNode(4);
		head.next.next.next.next = r.new ListNode(5);

		ListNode result = r.reverseKGroup(head, 2);

		System.out.println(result.val);

	}
}
