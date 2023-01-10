package practice;

import java.util.LinkedList;
import java.util.Queue;

//116 - Populating Next Right Pointers in Each Node

public class PopulatingNextRightPointersInEachNode {

	public Node connect(Node root) {
		if (root == null) {
			return null;
		}
		Node levelStart = root;
		while (levelStart != null) {
			Node current = levelStart;
			while (current != null) {
				if (current.left != null) {
					current.left.next = current.right;
				}
				if (current.right != null && current.next != null) {
					current.right.next = current.next.left;
				}
				current = current.next;
			}
			levelStart = levelStart.left;
		}
		return root;
	}

	public Node connectQueue(Node root) {

		if (root == null) {
			return root;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {

			int size = queue.size();
			for (int i = 0; i < size; i++) {

				Node node = queue.poll();

				if (i < size - 1) {
					node.next = queue.peek();
				}

				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
		return root;
	}
}
