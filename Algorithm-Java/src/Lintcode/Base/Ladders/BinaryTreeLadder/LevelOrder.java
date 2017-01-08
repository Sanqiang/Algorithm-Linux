package Lintcode.Base.Ladders.BinaryTreeLadder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
	/**
	 * @param root:
	 *            The root of binary tree.
	 * @return: Level order a list of lists of integer
	 */
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<>();
		if (root == null) {
			return results;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int cur_cnt = 1;
		int next_cnt = 0;
		ArrayList<Integer> result = new ArrayList<>();
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			--cur_cnt;
			result.add(temp.val);
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
			}
		}

		return results;
	}
}
