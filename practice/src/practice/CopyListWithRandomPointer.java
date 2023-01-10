package practice;

//138 - Copy List with Random Pointer

public class CopyListWithRandomPointer {
	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}
		Node temp = head;
		Node next;
		while (temp != null) {
			Node copy = new Node(temp.val);
			next = temp.next;
			temp.next = copy;
			copy.next = next;

			temp = next;
		}
		temp = head;
		while (temp != null) {
			if (temp.random != null) {
				temp.next.random = temp.random.next;
			}
			temp = temp.next.next;
		}
		temp = head;
		Node dummy = new Node(0);
		Node copy;
		Node copyTemp = dummy;

		while (temp != null) {
			next = temp.next.next;
			
			//extract the copy
			copy = temp.next;
			copyTemp.next = copy;
			copyTemp = copy;
			
			//restore the original
			temp.next = next;
			temp = next;
		}
		return dummy.next;
	}
}
