package Lintcode.Base.L3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import Lintcode.Base.L3.LevelOrder.TreeNode;

public class ZigzagLevelOrder {
	/**
	 * @param root:
	 *            The root of binary tree.
	 * @return: A list of lists of integer include the zigzag level order
	 *          traversal of its nodes' values
	 */
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<>();
		if (root == null) {
			return results;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int order = 0;

		while (!queue.isEmpty()) {
			ArrayList<Integer> result = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				result.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			if (order++ % 2 == 1) {
				Collections.reverse(result);
			}
			results.add(result);
		}

		return results;
	}
}
