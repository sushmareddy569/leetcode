package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//297 - Serialize and Deserialize Binary Tree

public class SerializeAndDeserializeBinaryTree {
	public String serialize(TreeNode root) {
		if (root == null)
			return "#";
		return root.val + "," + serialize(root.left) + "," + serialize(root.right);
	}

	public TreeNode deserialize(String data) {
		Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
		return deserial(queue);
	}

	private TreeNode deserial(Queue<String> queue) {
		String val = queue.poll();

		if (val.equals("#")) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(val));
		root.left = deserial(queue);
		root.right = deserial(queue);
		return root;
	}
}