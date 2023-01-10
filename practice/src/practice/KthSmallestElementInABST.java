package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 230 - Kth Smallest Element in a BST

public class KthSmallestElementInABST {
	public int kthSmallest(TreeNode root, int k) {
		ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
		return nums.get(k - 1);
	}

	public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> list) {
		if (root == null) {
			return list;
		}
		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);
		return list;
	}

	public int kthSmallest1(TreeNode root, int k) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			list.add(root.val);
			root = root.right;

			if (list.size() == k) {
				return list.get(k - 1);
			}
		}
		return -1;
	}
}
