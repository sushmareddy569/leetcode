package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//102 - Binary Tree Level Order Traversal

public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> innerList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				innerList.add(node.val);

				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			result.add(innerList);
		}

		return result;
	}

	public List<List<Integer>> levelOrder1(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		helper(result, root, 0);
		return result;
	}

	private void helper(List<List<Integer>> result, TreeNode root, int depth) {
		if (root == null) {
			return;
		}
		if (result.size() == depth) {
			result.add(new ArrayList<>());
		}
		result.get(depth).add(root.val);
		helper(result, root.left, depth + 1);
		helper(result, root.right, depth + 1);
	}
}
