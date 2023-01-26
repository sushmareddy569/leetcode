package practice;

// 1448 - Count Good Nodes in Binary Tree

public class CountGoodNodesInBinaryTree {
	public int goodNodes(TreeNode root) {
		return goodNodes(root, -10000);
	}

	public int goodNodes(TreeNode root, int max) {
		if (root == null) {
			return 0;
		}
		int result = root.val >= max ? 1 : 0;
		result += goodNodes(root.left, Math.max(max, root.val));
		result += goodNodes(root.right, Math.max(max, root.val));
		return result;
	}
}
