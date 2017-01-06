package Lintcode.Base.Ladders.LinkedListLadder;

public class DeleteDuplicates {
	/**
	 * @param ListNode
	 *            head is the head of the linked list
	 * @return: ListNode head of linked list
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode temp = head, loop = null;
		while (temp != null) {
			loop = temp.next;
			while (loop != null && loop.val == temp.val) {
				loop = loop.next;
			}

			temp.next = loop;
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

		while (temp != null) {
			if (temp.next != null && temp.next.next != null && temp.next.val == temp.next.next.val) {
				int val = temp.next.val;
				ListNode loop = temp.next;
				while(loop != null && loop.val == val){
					loop = loop.next;
				}
				temp.next = loop;
			}

			temp = temp.next;
		}

		return pre_head.next;
	}
}
