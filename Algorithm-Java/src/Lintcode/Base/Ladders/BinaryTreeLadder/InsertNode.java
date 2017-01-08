package Lintcode.Base.Ladders.BinaryTreeLadder;

public class InsertNode {
	/**
	 * @param root:
	 *            The root of the binary search tree.
	 * @param node:
	 *            insert this node into the binary search tree
	 * @return: The root of the new binary search tree.
	 */
	public TreeNode insertNode(TreeNode root, TreeNode node) {
		TreeNode temp = root;
		if(temp == null){
			return node;
		}
		while (true) {
			if (temp.val >= node.val) {
				if (temp.left == null) {
					temp.left = node;
					break;
				} else {
					temp = temp.left;
				}
			} else {
				if (temp.right == null) {
					temp.right = node;
					break;
				} else {
					temp = temp.right;
				}
			}
		}

		return root;
	}
}
