package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//144 - Binary Tree Preorder Traversal

public class BinaryTreePreorderTraversal {

	public List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node != null) {
				list.add(node.val);
				stack.push(node.right);
				stack.push(node.left);
			}
		}
		return list;
	}

	public List<Integer> preorderTraversal2(TreeNode root) {
		return helper(root, new ArrayList<Integer>());
	}

	private List<Integer> helper(TreeNode root, ArrayList<Integer> list) {
		if (root == null) {
			return list;
		}

		list.add(root.val);
		helper(root.left, list);
		helper(root.right, list);
		return list;
	}
}
