package practice;

//117 - Populating Next Right Pointers in Each NodeII

public class PopulatingNextRightPointersInEachNodeII {

	public Node connect(Node root) {
		if (root == null) {
			return null;
		}
		Node levelStart = root;

		while (levelStart != null) {
			Node current = levelStart;
			Node nextLevel = null;
			levelStart = null; 

			while (current != null) {

				if (current.left != null) {
					if (nextLevel != null) {
						nextLevel.next = current.left;
					} else {
						levelStart = current.left;
					}
					nextLevel = current.left;
				}

				if (current.right != null) {
					if (nextLevel != null) {
						nextLevel.next = current.right;
					} else {
						levelStart = current.right;
					}
					nextLevel = current.right;
				}
				current = current.next;
			}
		}
		return root;
	}
}
