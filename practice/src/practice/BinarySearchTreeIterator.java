package practice;

import java.util.Stack;

//173 - Binary Search Tree Iterator

public class BinarySearchTreeIterator {
	private Stack<TreeNode> stack = new Stack<>();

	public BinarySearchTreeIterator(TreeNode root) {
		pushAll(root);
	}

	public int next() {
		TreeNode curr = stack.pop();
		pushAll(curr.right);
		return curr.val;
	}

	private void pushAll(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}
}
