package Lintcode.Base.L3;

import Lintcode.Base.L3.LevelOrder.TreeNode;

public class InsertNode {
	/**
	 * @param root:
	 *            The root of the binary search tree.
	 * @param node:
	 *            insert this node into the binary search tree
	 * @return: The root of the new binary search tree.
	 */
	public TreeNode insertNode(TreeNode root, TreeNode node) {
		if (true) {
			if (root == null) {
				return node;
			}
			if (node.val >= root.val) {
				root.right = insertNode(root.right, node);
			}
			if (node.val < root.val) {
				root.left = insertNode(root.left, node);
			}
			return root;
		} else {
			TreeNode temp = root;
			if (temp == null) {
				return node;
			}
			while (temp != null) {
				if (node.val >= temp.val) {
					if (temp.right == null) {
						temp.right = node;
					} else {
						temp = node.right;
					}
				} else if (node.val < temp.val) {
					if (temp.left == null) {
						temp.left = node;
					} else {
						temp = node.left;
					}
				}
			}

			return root;
		}
	}
}
