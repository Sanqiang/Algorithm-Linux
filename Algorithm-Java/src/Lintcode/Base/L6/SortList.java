package Lintcode.Base.L6;

import Lintcode.Base.L6.DeleteDuplicates.ListNode;

public class SortList {
	/**
	 * @param head:
	 *            The head of linked list.
	 * @return: You should return the head of the sorted linked list, using
	 *          constant space complexity.
	 */
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode mid = findMiddle(head);
		ListNode right = sortList(mid.next);
		mid.next = null;
		ListNode left = sortList(head);
		return merge(left, right);
	}

	ListNode merge(ListNode head1, ListNode head2) {
		ListNode pre_head = new ListNode(0);
		ListNode temp = pre_head;

		while (head1 != null && head2 != null) {
			if (head1.val <= head2.val) {
				temp.next = head1;
				head1 = head1.next;
			} else {
				temp.next = head2;
				head2 = head2.next;
			}
			temp = temp.next;
		}
		while (head1 != null) {
			temp.next = head1;
			head1 = head1.next;
		}
		while (head2 != null) {
			temp.next = head2;
			head2 = head2.next;
		}

		return pre_head.next;
	}

	ListNode findMiddle(ListNode head) {
		ListNode slow_node = head, fast_node = head.next;

		while (fast_node != null && fast_node.next != null) {
			slow_node = slow_node.next;
			fast_node = fast_node.next.next;
		}

		return slow_node;
	}
}
