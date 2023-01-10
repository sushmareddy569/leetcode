package practice;

import java.util.LinkedList;
import java.util.Queue;

// 226 - InvertBinary Tree

public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode left = root.left;
		TreeNode right = root.right;

		root.left = invertTree(right);
		root.right = invertTree(left);

		return root;
	}

	public TreeNode invertTree1(TreeNode root) {
		if (root == null) {
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			TreeNode left = node.left;
			node.left = node.right;
			node.right = left;

			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		return root;
	}
}
