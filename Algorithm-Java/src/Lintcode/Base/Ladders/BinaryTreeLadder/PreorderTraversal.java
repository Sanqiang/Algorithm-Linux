package Lintcode.Base.Ladders.BinaryTreeLadder;

import java.util.ArrayList;

public class PreorderTraversal {
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
		result.add(root.val);

		ArrayList<Integer> left = preorderTraversal(root.left), right = preorderTraversal(root.right);
		result.addAll(left);
		result.addAll(right);
		
		return result;
	}
}
