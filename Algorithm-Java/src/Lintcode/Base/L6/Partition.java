package Lintcode.Base.L6;

import Lintcode.Base.L6.DeleteDuplicates.ListNode;

public class Partition {
	/**
	 * @param head:
	 *            The first node of linked list.
	 * @param x:
	 *            an integer
	 * @return: a ListNode
	 */
	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		}

		ListNode pre_head_small = new ListNode(0);
		ListNode pre_head_large = new ListNode(0);
		ListNode temp_small = pre_head_small, temp_large = pre_head_large;

		while (head != null) {
			if (head.val < x) {
				temp_small.next = head;
				temp_small = head;
			} else {
				temp_large.next = head;
				temp_large = head;
			}
			head = head.next;
		}

		temp_large.next = null;
		temp_small.next = pre_head_large.next;
		return pre_head_small.next;
	}
}
