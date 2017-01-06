package Lintcode.Base.Ladders.LinkedListLadder;

public class Reverse {
	/**
	 * @param head:
	 *            The head of linked list.
	 * @return: The new head of reversed linked list.
	 */
	public ListNode reverse(ListNode head) {
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

	/**
	 * @param ListNode
	 *            head is the head of the linked list
	 * @oaram m and n
	 * @return: The head of the reversed ListNode
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode pre_head = new ListNode(0);
		pre_head.next = head;
		
		ListNode pri = pre_head;
		for(int i = 0; i < m - 1; ++i){
			pri = pri.next;
		}
		ListNode left1 = pri;
		pri = pri.next;
		ListNode left2 = pri;
		ListNode cur = pri.next;
		for(int i = m; i < n; ++i){
			ListNode next = cur.next;
			cur.next = pri;
			pri = cur;
			cur = next;
		}
		left1.next = pri;
		left2.next = cur;
		
		return pre_head.next;
	}
}
