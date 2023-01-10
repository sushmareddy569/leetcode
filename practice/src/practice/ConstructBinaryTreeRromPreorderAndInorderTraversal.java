package practice;

import java.util.HashMap;

//105 - Construct Binary Tree from Preorder and Inorder Traversal

public class ConstructBinaryTreeRromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int n = inorder.length;
		return helper(0, 0, n - 1, preorder, inorder);
	}

	private TreeNode helper(int preIndex, int inStart, int inEnd, int[] preorder, int[] inorder) {
		if (preIndex > preorder.length - 1 || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preIndex]);

		int inIndex = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (root.val == inorder[i]) {
				inIndex = i;
			}
		}
		root.left = helper(preIndex + 1, inStart, inIndex - 1, preorder, inorder);
		root.right = helper(preIndex + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
		return root;
	}

	// O(n) time and O(n) space
	int preIndex = 0;

	public TreeNode buildTreeUsingMap(int[] preOrder, int[] inOrder) {
		int n = inOrder.length;
		HashMap<Integer, Integer> inOrderMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			inOrderMap.put(inOrder[i], i);
		}
		return buildTree(preOrder, inOrder, 0, n - 1, inOrderMap);
	}

	private TreeNode buildTree(int[] preOrder, int[] inOrder, int start, int end,
			HashMap<Integer, Integer> inOrderMap) {
		if (start > end || preIndex > preOrder.length - 1) {
			return null;
		}
		TreeNode root = new TreeNode(preOrder[preIndex]);
		preIndex++;

		int index = inOrderMap.get(root.val);

		root.left = buildTree(preOrder, inOrder, start, index - 1, inOrderMap);
		root.right = buildTree(preOrder, inOrder, index + 1, end, inOrderMap);

		return root;
	}
}
