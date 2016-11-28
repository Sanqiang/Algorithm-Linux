package Lintcode.Base.L3;

public class MaxDepth {
	public class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

	/**
	 * @param root:
	 *            The root of binary tree.
	 * @return: An integer.
	 */
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left_depth = maxDepth(root.left);
		int right_depth = maxDepth(root.right);

		return Math.max(left_depth, right_depth) + 1;
	}
}
