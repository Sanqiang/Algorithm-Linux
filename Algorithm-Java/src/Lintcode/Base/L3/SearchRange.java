package Lintcode.Base.L3;

import java.util.ArrayList;

import Lintcode.Base.L3.LevelOrder.TreeNode;

public class SearchRange {
	/**
	 * @param root:
	 *            The root of the binary search tree.
	 * @param k1
	 *            and k2: range k1 to k2.
	 * @return: Return all keys that k1<=key<=k2 in ascending order.
	 */
	public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
		ArrayList<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		if (root.val >= k1) {
			ArrayList<Integer> left_result = searchRange(root.left, k1, k2);
			result.addAll(left_result);
		}

		if (root.val >= k1 && root.val <= k2) {
			result.add(root.val);
		}

		if (root.val <= k2) {
			ArrayList<Integer> right_result = searchRange(root.right, k1, k2);
			result.addAll(right_result);
		}

		return result;
	}
}
