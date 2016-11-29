package Lintcode.Base.L8;

import java.util.LinkedList;

public class MaxTree {
	class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

	/**
	 * @param A:
	 *            Given an integer array with no duplicates.
	 * @return: The root of max tree.
	 */
	public TreeNode maxTree(int[] A) {
		// write your code here
		if (A == null || A.length == 0) {
			return null;
		}
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		for (int i = 0; i < A.length; i++) {
			TreeNode cur = new TreeNode(A[i]);
			while (!stack.isEmpty() && cur.val > stack.peek().val) {
				cur.left = stack.pop();
			}
			if (!stack.isEmpty()) {
				stack.peek().right = cur;
			}
			stack.push(cur);
		}
		TreeNode result = new TreeNode(0);
		while (!stack.isEmpty()) {
			result = stack.pop();
		}
		return result;
	}

	public static void main(String[] args) {
		int[] A = { 2, 5, 6, 0, 3, 1 };
		new MaxTree().maxTree(A);
	}
}
