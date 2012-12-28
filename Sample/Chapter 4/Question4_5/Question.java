package Question4_5;

import CtCILibrary.TreeNode;

public class Question {
	public static int last_printed = Integer.MIN_VALUE;
	public static boolean checkBST(TreeNode n) {
		if (n == null) {
			return true;
		}
		
		// Check / recurse left
		if (!checkBST(n.left)) {
			return false;
		}
		
		// Check current
		if (n.data < last_printed) {
			return false;
		}
		last_printed = n.data;
		
		// Check / recurse right
		if (!checkBST(n.right)) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] array = {3, 5, 7, 10, 13, 15, 20};
		TreeNode node = TreeNode.createMinimalBST(array);
		//node.left.right.data = 3;
		System.out.println(checkBST(node));
	}
}