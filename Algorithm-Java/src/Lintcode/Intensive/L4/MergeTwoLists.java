package Lintcode.Intensive.L4;

public class MergeTwoLists {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	/**
	 * @param ListNode
	 *            l1 is the head of the linked list
	 * @param ListNode
	 *            l2 is the head of the linked list
	 * @return: ListNode head of linked list
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode last = head;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				last.next = l1;
				last = l1;
				l1 = l1.next;
			} else {
				last.next = l2;
				last = l2;
				l2 = l2.next;
			}
		}
		while (l1 != null) {
			last.next = l1;
			last = l1;
			l1 = l1.next;
		}
		while (l2 != null) {
			last.next = l2;
			last = l2;
			l2 = l2.next;
		}

		return head.next;
	}
}
