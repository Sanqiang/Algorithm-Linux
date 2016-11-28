package Lintcode.Base.L6;

import Lintcode.Base.L6.DeleteDuplicates.ListNode;

public class Reverse {
	/**
	 * @param head:
	 *            The head of linked list.
	 * @return: The new head of reversed linked list.
	 */
	public ListNode reverse(ListNode head) {
		ListNode pre_node = null;
		while (head != null) {
			ListNode next_node = head.next;
			head.next = pre_node;

			pre_node = head;
			head = next_node;
		}
		return pre_node;
	}

	/**
	 * @param ListNode
	 *            head is the head of the linked list
	 * @oaram m and n
	 * @return: The head of the reversed ListNode
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode pre_head = new ListNode(0);
		pre_head.next = head;

		// 1->2->3->4->5->null
		// 1->4->3->2->5->null

		ListNode temp = pre_head;
		for (int i = 0; i < m - 1; i++) {
			temp = temp.next;
		}

		ListNode pre_last_node = temp, cur_last_node = temp.next;
		ListNode pre_node = pre_last_node.next, cur_node = cur_last_node.next;
		for (int i = m; i < n; i++) {
			ListNode next_node = cur_node.next;
			cur_node.next = pre_node;

			pre_node = cur_node;
			cur_node = next_node;
		}

		pre_last_node.next = pre_node;
		cur_last_node.next = cur_node;

		return pre_head.next;
	}
}
