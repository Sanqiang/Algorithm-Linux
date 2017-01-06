package Lintcode.Base.Ladders.LinkedListLadder;

public class RemoveNthFromEnd {
	ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n == 0) {
			return null;
		}

		ListNode pre_head = new ListNode(-1);
		pre_head.next = head;

		ListNode slow = pre_head, fast = pre_head;
		for (int i = 0; i < 1 + n; ++i) {
			fast = fast.next;
		}
		
		while(fast != null){
			slow = slow.next;
			fast = fast.next;
		}
		
		slow.next = slow.next.next;

		return pre_head.next;
	}
}
