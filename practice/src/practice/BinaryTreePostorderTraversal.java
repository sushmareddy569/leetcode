package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//145 - Binary Tree Postorder Traversal

public class BinaryTreePostorderTraversal {

	public List<Integer> postorderTraversal1(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node != null) {
				list.add(0, node.val);
				stack.push(node.left);
				stack.push(node.right);
			}
		}

		return list;
	}

	public List<Integer> postorderTraversal2(TreeNode root) {
		return helper(root, new ArrayList<Integer>());
	}

	private List<Integer> helper(TreeNode root, ArrayList<Integer> list) {
		if (root == null) {
			return list;
		}
		helper(root.left, list);
		helper(root.right, list);
		list.add(root.val);
		return list;
	}
}
