package Lintcode.Base.Ladders.BinaryTreeLadder;

public class MinDepth {
	/**
	 * @param root:
	 *            The root of binary tree.
	 * @return: An integer.
	 */
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return getMinDepth(root);
		}
	}

	int getMinDepth(TreeNode root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}else if(root.left == null && root.right == null){
			return 1;
		}
		int left = getMinDepth(root.left);
		int right = getMinDepth(root.right);
		int min = Math.min(left, right);
		if (min == Integer.MAX_VALUE) {
			return 1;
		} else {
			return 1 + min;
		}
	}
}
