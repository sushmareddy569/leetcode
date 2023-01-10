package practice;

//701 - Insert into a Binary Search Tree

public class InsertIntoABinarySearchTree {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		if (root.val > val) {
			root.left = insertIntoBST(root.left, val);
		} else {
			root.right = insertIntoBST(root.right, val);
		}
		return root;
	}
}
