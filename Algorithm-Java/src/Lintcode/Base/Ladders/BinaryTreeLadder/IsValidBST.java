package Lintcode.Base.Ladders.BinaryTreeLadder;

public class IsValidBST {
	/**
	 * @param root:
	 *            The root of binary tree.
	 * @return: True if the binary tree is BST, or false
	 */
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	boolean isValidBST(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		} else if (root.val <= min || root.val >= max) {
			return false;
		}

		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
	}

}
