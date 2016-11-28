package Lintcode.Base.L6;

import Lintcode.Base.L6.DeleteDuplicates.ListNode;

public class ReverseKGroup {
	/**
	 * @param head
	 *            a ListNode
	 * @param k
	 *            an integer
	 * @return a ListNode
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return null;
		}

		ListNode pre_head = new ListNode(0);
		pre_head.next = head;

		ListNode temp = pre_head;
		while (temp != null) {
			temp = reverseByK(temp, k);
		}

		return pre_head.next;
	}

	ListNode reverseByK(ListNode head, int k) {
		// check space
		ListNode temp = head;
		for (int i = 0; i < k; i++) {
			if (temp.next == null) {
				return null;
			}
			temp = temp.next;
		}

		// reverse
		ListNode pre_last_node = head, cur_last_node = head.next;
		ListNode pre_node = head.next, cur_node = pre_node.next;
		for (int i = 0; i < k - 1; i++) {
			ListNode next_node = cur_node.next;
			cur_node.next = pre_node;

			pre_node = cur_node;
			cur_node = next_node;
		}

		pre_last_node.next = pre_node;
		cur_last_node.next = cur_node;

		return cur_last_node;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1), n2 = new ListNode(2), n3 = new ListNode(3), n4 = new ListNode(4),
				n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		new ReverseKGroup().reverseKGroup(n1, 2);
	}
}
