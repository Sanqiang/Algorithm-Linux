package Lintcode.Base.L3;

public class LowestCommonAncestor {
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
	 *            The root of the binary search tree.
	 * @param A
	 *            and B: two nodes in a Binary.
	 * @return: Return the least common ancestor(LCA) of the two nodes.
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
		if (root == null || root == A || root == B) {
			return root;
		}

		TreeNode node_left = lowestCommonAncestor(root.left, A, B);
		TreeNode node_right = lowestCommonAncestor(root.right, A, B);

		if (node_left != null && node_right != null) {
			return root;
		} else if (node_left != null) {
			return node_left;
		} else if (node_right != null) {
			return node_right;
		} else {
			return null;
		}
	}

}
