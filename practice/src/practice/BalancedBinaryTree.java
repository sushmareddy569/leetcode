package practice;

//110 - Balanced Binary Tree

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		int left = depth(root.left);
		int right = depth(root.right);
		return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}

	public int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(depth(root.left), depth(root.right)) + 1;
	}

	public boolean isBalanced1(TreeNode root) {
		return dfsHeight(root) != -1;
	}

	public int dfsHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = dfsHeight(root.left);

		int right = dfsHeight(root.right);

		int balanceFactor = Math.abs(left - right);

		if (balanceFactor > 1 || left == -1 || right == -1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}
}
