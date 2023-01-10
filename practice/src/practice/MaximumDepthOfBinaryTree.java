package practice;

//104 - Maximum Depth of Binary Tree 

public class MaximumDepthOfBinaryTree {

	public int maxDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		MaximumDepthOfBinaryTree max = new MaximumDepthOfBinaryTree();

		TreeNode root = new TreeNode(1);
		TreeNode left1 = new TreeNode(2);
		TreeNode right1 = new TreeNode(3);
		TreeNode left2 = new TreeNode(4);
		TreeNode right2 = new TreeNode(5);
		TreeNode left3 = new TreeNode(6);
		TreeNode right3 = new TreeNode(7);

		root.left = left1;
		root.right = right1;
		left1.left = left2;
		left1.right = right2;
		right1.left = left3;
		right1.right = right3;

		System.out.println(max.maxDepth(root));
	}
}
