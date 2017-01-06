package Lintcode.Base.Ladders.LinkedListLadder;

public class SortedListToBSTHelper {
	/**
	 * @param head:
	 *            The first node of linked list.
	 * @return: a tree node
	 */
	public TreeNode sortedListToBST(ListNode head) {
		int length = getLength(head);
		temp = head;
		return getTreeNode(length);
	}

	ListNode temp = null;

	TreeNode getTreeNode(int steps) {
		if (steps <= 0) {
			return null;
		}
		TreeNode left_child = getTreeNode(steps / 2);
		TreeNode node = new TreeNode(temp.val);
		temp = temp.next;
		TreeNode right_child = getTreeNode(steps - 1 - steps / 2);
		node.left = left_child;
		node.right = right_child;
		return node;
	}

	int getLength(ListNode head) {
		int cnt = 0;
		ListNode temp = head;
		while (temp != null) {
			temp = temp.next;
			++cnt;
		}
		return cnt;
	}

}
