package Lintcode.Base.L3;

import Lintcode.Base.L3.LevelOrder.TreeNode;

public class MaxPathSum {
	/**
	 * @param root:
	 *            The root of binary tree.
	 * @return: An integer.
	 */
	public int maxPathSum(TreeNode root) {
		return maxPathSumHeler(root).double_sum;
	}

	class ReturnWrapper {
		public int single_sum = 0, double_sum = Integer.MIN_VALUE;
	}

	ReturnWrapper maxPathSumHeler(TreeNode root) {
		if (root == null) {
			return new ReturnWrapper();
		}

		ReturnWrapper left_wrapper = maxPathSumHeler(root.left);
		ReturnWrapper right_wrapper = maxPathSumHeler(root.right);

		ReturnWrapper wrapper = new ReturnWrapper();
		wrapper.single_sum = Math.max(0, Math.max(left_wrapper.single_sum, right_wrapper.single_sum) + root.val);
		wrapper.double_sum = Math.max(left_wrapper.single_sum + right_wrapper.single_sum + root.val,
				Math.max(left_wrapper.double_sum, right_wrapper.double_sum));

		return wrapper;
	}
}
