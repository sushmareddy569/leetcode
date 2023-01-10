package practice;

//98 - Validate Binary Search Tree

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean isBST(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}
		if (root.val > min && root.val < max) {
			return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
		}
		return false;
	}
}
