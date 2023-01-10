package practice;

// 572 - Subtree of Another Tree

public class SubtreeOfAnotherTree {
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null || subRoot == null) {
			return false;
		}
		return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	public boolean isSame(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null || p.val != q.val) {
			return false;
		}
		return isSame(p.left, q.left) && isSame(p.right, q.right);
	}
}
