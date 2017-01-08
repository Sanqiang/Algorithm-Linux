package Lintcode.Base.Ladders.BinaryTreeLadder;

public class BuildTree {
	/**
	 * @param preorder
	 *            : A list of integers that preorder traversal of a tree
	 * @param inorder
	 *            : A list of integers that inorder traversal of a tree
	 * @return : Root of a tree
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(preorder, inorder, 0, preorder.length, 0, inorder.length);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
		if (ps > pe || is > ie || ps >= preorder.length || ps < 0) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[ps]);
		int pivot_idx_in_inorder = findSplit(preorder, inorder, ps, pe, is, ie);
		int left_interval = pivot_idx_in_inorder - 1 - is;
		// int right_interval = ie - pivot_idx_in_inorder - 1;
		root.left = buildTree(preorder, inorder, ps + 1, ps + 1 + left_interval, is, pivot_idx_in_inorder - 1);
		root.right = buildTree(preorder, inorder, ps + 1 + left_interval + 1, pe, pivot_idx_in_inorder + 1, ie);
		return root;
	}

	int findSplit(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
		int pivot = preorder[ps];
		for (int i = is; i <= ie; ++i) {
			if (inorder[i] == pivot) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @param inorder
	 *            : A list of integers that inorder traversal of a tree
	 * @param postorder
	 *            : A list of integers that postorder traversal of a tree
	 * @return : Root of a tree
	 */
	public TreeNode buildTree2(int[] inorder, int[] postorder) {
		return buildTree2(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
	}

	public TreeNode buildTree2(int[] inorder, int[] postorder, int is, int ie, int ps, int pe) {
		if (ps > pe || is > ie || pe < 0 || pe >= postorder.length) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[pe]);
		int pivot_idx_in_inorder = findSplit2(inorder, postorder, is, ie, ps, pe);
		int left_interval = pivot_idx_in_inorder - 1 - is;
		root.left = buildTree2(inorder, postorder, is, pivot_idx_in_inorder - 1, ps, ps + left_interval);
		root.right = buildTree2(inorder, postorder, pivot_idx_in_inorder + 1, ie, ps + left_interval + 1, pe - 1);
		return root;
	}

	int findSplit2(int[] inorder, int[] postorder, int is, int ie, int ps, int pe) {
		int pivot = postorder[pe];
		for (int i = is; i <= ie; ++i) {
			if (inorder[i] == pivot) {
				return i;
			}
		}
		return -1;
	}
}
