package practice;

import java.util.LinkedList;
import java.util.Queue;

// 100 - Same Tree

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public boolean isSameTree1(TreeNode p, TreeNode q) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(p);
		queue.add(q);

		while (!queue.isEmpty()) {
			TreeNode n1 = queue.poll();
			TreeNode n2 = queue.poll();

			if (n1 == null && n2 == null) {
				continue;
			}
			if (n1 == null || n2 == null || n1.val != n2.val) {
				return false;
			}
			queue.offer(n1.left);
			queue.offer(n2.left);
			queue.offer(n1.right);
			queue.offer(n2.right);
		}
		return true;
	}
}
