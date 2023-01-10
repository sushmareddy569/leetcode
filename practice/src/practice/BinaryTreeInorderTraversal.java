package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//94 - Binary Tree Inorder Traversal

public class BinaryTreeInorderTraversal {

	public List<Integer> inorderTraversal1(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			list.add(root.val);
			root = root.right;
		}
		return list;
	}

	public List<Integer> inorderTraversal2(TreeNode root) {
		return helper(root, new ArrayList<Integer>());
	}

	private List<Integer> helper(TreeNode root, ArrayList<Integer> list) {
		if (root == null) {
			return list;
		}
		helper(root.left, list);
		list.add(root.val);
		helper(root.right, list);
		return list;
	}
}
