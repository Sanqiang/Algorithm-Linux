package Lintcode.Base.L6;

public class DeleteDuplicates {
	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/**
	 * @param ListNode
	 *            head is the head of the linked list
	 * @return: ListNode head of linked list
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode temp = head;

		while (temp != null) {
			while (temp.next != null && temp.val == temp.next.val) {
				temp.next = temp.next.next;
			}
			temp = temp.next;
		}

		return head;
	}

	/**
	 * @param ListNode
	 *            head is the head of the linked list
	 * @return: ListNode head of the linked list
	 */
	public static ListNode deleteDuplicates2(ListNode head) {
		ListNode pre_head = new ListNode(-1);
		pre_head.next = head;

		ListNode temp = pre_head;
		while (temp.next != null && temp.next.next != null) {
			if (temp.next.val == temp.next.next.val) {
				int check_Val = temp.next.val;
				ListNode loop = temp.next.next;
				while (loop != null && loop.val == check_Val) {
					loop = loop.next;
				}
				temp.next = loop;
			} else {
				temp = temp.next;
			}
		}

		return pre_head.next;
	}
}
