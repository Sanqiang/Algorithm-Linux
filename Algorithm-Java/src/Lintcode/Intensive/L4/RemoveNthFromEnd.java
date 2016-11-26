package Lintcode.Intensive.L4;

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

public class RemoveNthFromEnd {
	/**
	 * @param head:
	 *            The first node of linked list.
	 * @param n:
	 *            An integer.
	 * @return: The head of linked list.
	 */
	ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n == 0) {
			return null;
		}
		ListNode pre_head = new ListNode(0);
		pre_head.next = head;

		ListNode loop_slow = pre_head, loop_fast = pre_head;
		for (int i = 0; i <= n - 1; i++) {
			loop_fast = loop_fast.next;
			if (loop_fast.next == null) {
				return null;
			}
		}
		while (true) {
			if (loop_fast.next == null) {
				break;
			}
			loop_slow = loop_slow.next;
			loop_fast = loop_fast.next;
		}
		loop_slow.next = loop_slow.next.next;

		return pre_head.next;
	}
}
