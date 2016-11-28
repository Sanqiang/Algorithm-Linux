package Lintcode.Base.L3;

public class IsBalanced {
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
	 * @return: True if this Binary tree is Balanced, or false.
	 */
	public boolean isBalanced(TreeNode root) {
		return getDepth(root) != -1;
	}

	int getDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left_depth = getDepth(root.left);
		int right_depth = getDepth(root.right);

		if (left_depth == -1 || right_depth == -1 || Math.abs(left_depth - right_depth) > 1) {
			return -1;
		}

		return Math.max(left_depth, right_depth) + 1;
	}
}
