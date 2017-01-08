package Lintcode.Base.Ladders.BinaryTreeLadder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SearchRange {
	/**
	 * @param root:
	 *            The root of the binary search tree.
	 * @param k1
	 *            and k2: range k1 to k2.
	 * @return: Return all keys that k1<=key<=k2 in ascending order.
	 */
	public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
		ArrayList<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			if (temp.val >= k1 && temp.val <= k2) {
				result.add(temp.val);
			}
			if (temp.val > k1 && temp.left != null) {
				q.add(temp.left);
			}
			if (temp.val < k2 && temp.right != null) {
				q.add(temp.right);
			}
		}

		Collections.sort(result);
		return result;
	}

	public ArrayList<Integer> searchRangeDFS(TreeNode root, int k1, int k2) {
		ArrayList<Integer> result = new ArrayList<>();
		dfs(root, k1, k2, result);
		return result;
	}

	void dfs(TreeNode root, int k1, int k2, ArrayList<Integer> result) {
		if (root == null) {
			return;
		}

		if (root.val > k1) {
			dfs(root.left, k1, k2, result);
		}
		if (root.val >= k1 && root.val <= k2) {
			result.add(root.val);
		}
		if (root.val < k2) {
			dfs(root.right, k1, k2, result);
		}
	}
}
