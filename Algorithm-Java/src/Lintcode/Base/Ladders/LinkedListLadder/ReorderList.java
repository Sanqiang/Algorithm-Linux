package Lintcode.Base.Ladders.LinkedListLadder;

public class ReorderList {
	/**
	 * @param head:
	 *            The head of linked list.
	 * @return: void
	 */
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode mid = findMiddle(head);
		ListNode right = reverseList(mid.next);
		mid.next = null;
		head = mergeList(head, right);
	}

	ListNode mergeList(ListNode head1, ListNode head2) {
		ListNode pre_head = new ListNode(-1);
		ListNode loop = pre_head;
		while (head1 != null && head2 != null) {
			loop.next = head1;
			head1 = head1.next;

			loop = loop.next;

			loop.next = head2;
			head2 = head2.next;

			loop = loop.next;
		}
		if (head1 != null) {
			loop.next = head1;
		} else {
			loop.next = head2;
		}

		return pre_head.next;
	}

	ListNode findMiddle(ListNode head) {
		ListNode slow = head, fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode pri = head, cur = head.next;
		head.next = null;
		while (cur != null) {
			ListNode nex = cur.next;

			cur.next = pri;

			pri = cur;
			cur = nex;
		}

		return pri;
	}
}
