package Lintcode.Base.Ladders.BinaryTreeLadder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
		boolean is_order = true;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int cur_cnt = 1;
		int next_cnt = 0;
		ArrayList<Integer> result = new ArrayList<>();
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			--cur_cnt;
			if (is_order) {
				result.add(temp.val);
			} else {
				result.add(0, temp.val);
			}
			if (temp.left != null) {
				q.add(temp.left);
				++next_cnt;
			}
			if (temp.right != null) {
				q.add(temp.right);
				++next_cnt;
			}
			if (cur_cnt == 0) {
				cur_cnt = next_cnt;
				next_cnt = 0;
				results.add(result);
				result = new ArrayList<>();
				is_order = !is_order;
			}
		}
		return results;
	}
}
