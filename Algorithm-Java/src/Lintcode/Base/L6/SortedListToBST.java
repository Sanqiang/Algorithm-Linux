package Lintcode.Base.L6;

public class SortedListToBST {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

	/**
	 * @param head:
	 *            The first node of linked list.
	 * @return: a tree node
	 */
	public TreeNode sortedListToBST(ListNode head) {
		int size;

		current_node = head;
		size = getListLength(head);

		return sortedListToBSTHelper(size);
	}

	static ListNode current_node;

	TreeNode sortedListToBSTHelper(int size) {
		if (size <= 0) {
			return null;
		}

		TreeNode left_node = sortedListToBSTHelper(size / 2);
		TreeNode node = new TreeNode(current_node.val);
		current_node = current_node.next;
		TreeNode right_node = sortedListToBSTHelper(size - 1 - size / 2);

		node.left = left_node;
		node.right = right_node;
		return node;
	}

	int getListLength(ListNode head) {
		int size = 0;

		while (head != null) {
			size++;
			head = head.next;
		}

		return size;
	}
}
