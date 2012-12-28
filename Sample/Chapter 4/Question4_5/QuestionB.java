package Question4_5;

import CtCILibrary.TreeNode;

public class QuestionB {
	public static boolean checkBST(TreeNode n, int min, int max) {
		if (n == null) {
			return true;
		}
		if (n.data <= min || n.data > max) {
			return false;
		}
		if (!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)) {
			return false;
		}
		return true;
	}
	
	public static boolean checkBST(TreeNode n) {
		return checkBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static void main(String[] args) {
		int[] array = {3, 5, 7, 10, 13, 15, 20};
		TreeNode node = TreeNode.createMinimalBST(array);
		node.left.right.data = 3;
		System.out.println(checkBST(node));
	}
}
