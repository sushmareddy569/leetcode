package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 199 - Binary Tree Right Side View

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null) {
			return result;
		}

		queue.offer(root);
		while (queue.size() != 0) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.poll();
				if (i == 0) {
					result.add(curr.val);
				}
				if (curr.right != null) {
					queue.offer(curr.right);
				}
				if (curr.left != null) {
					queue.offer(curr.left);
				}
			}
		}
		return result;
	}
}
