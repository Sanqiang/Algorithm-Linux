package Lintcode.Base.L3;

import java.util.ArrayList;

public class PreorderTraversal {
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
	 * @return: Preorder in ArrayList which contains node values.
	 */
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		
		ArrayList<Integer> left_list = preorderTraversal(root.left);
		ArrayList<Integer> right_list = preorderTraversal(root.right);
		
		result.add(root.val);
		result.addAll(left_list);
		result.addAll(right_list);
		
		return result;
	}
}
