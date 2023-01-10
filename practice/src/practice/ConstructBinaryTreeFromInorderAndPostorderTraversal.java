package practice;

import java.util.HashMap;

//106 - Construct Binary Tree from Inorder and Postorder Traversal

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	int postIndex = 0;

	public TreeNode buildTreeUsingMap(int[] inorder, int[] postorder) {

		int n = inorder.length;
		postIndex = n - 1;
		HashMap<Integer, Integer> inOrderMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			inOrderMap.put(inorder[i], i);
		}
		return buildTree0(postorder, inorder, 0, n - 1, inOrderMap);
	}

	private TreeNode buildTree0(int[] postorder, int[] inorder, int start, int end,
			HashMap<Integer, Integer> inOrderMap) {
		if (start > end || postIndex < 0) {
			return null;
		}

		TreeNode root = new TreeNode(postorder[postIndex--]);

		int index = inOrderMap.get(root.val);

		root.right = buildTree0(postorder, inorder, index + 1, end, inOrderMap);
		root.left = buildTree0(postorder, inorder, start, index - 1, inOrderMap);

		return root;
	}

	int pIndex;

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int len = inorder.length - 1;
		pIndex = len;
		return dfs(postorder, inorder, 0, len);
	}

	private TreeNode dfs(int[] postorder, int[] inorder, int start, int end) {
		if (start > end || pIndex < 0) {
			return null;
		}

		TreeNode root = new TreeNode(postorder[pIndex]);
		pIndex--;
		int index = 0;
		for (int i = start; i <= end; i++) {
			if (inorder[i] == root.val) {
				index = i;
			}
		}
		root.right = dfs(postorder, inorder, index + 1, end);
		root.left = dfs(postorder, inorder, start, index - 1);

		return root;
	}
}
