package Lintcode.Base.Ladders.BinaryTreeLadder;

public class IsBalanced {
	/**
	 * @param root:
	 *            The root of binary tree.
	 * @return: True if this Binary tree is Balanced, or false.
	 */
	public boolean isBalanced(TreeNode root) {
		return getDiff(root) != -1;
	}

	int getDiff(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getDiff(root.left);
		if (left == -1) {
			return -1;
		}
		int right = getDiff(root.right);
		if (right == -1) {
			return -1;
		}

		if (Math.abs(left - right) > 1) {
			return -1;
		} else {
			return 1 + Math.max(left, right);
		}
	}
}
