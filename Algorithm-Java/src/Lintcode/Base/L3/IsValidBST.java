package Lintcode.Base.L3;

import Lintcode.Base.L3.LevelOrder.TreeNode;

public class IsValidBST {
	/**
	 * @param root:
	 *            The root of binary tree.
	 * @return: True if the binary tree is BST, or false
	 */
	public boolean isValidBST(TreeNode root) {
		return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	boolean helper(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		} else if (root.val <= min || root.val >= max) {
			return false;
		}

		boolean left_flag = helper(root.left, min, root.val);
		boolean right_flag = helper(root.right, root.val, max);
		return left_flag && right_flag;
	}
}
