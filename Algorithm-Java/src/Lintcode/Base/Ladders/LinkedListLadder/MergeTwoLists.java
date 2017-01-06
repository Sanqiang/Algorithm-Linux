package Lintcode.Base.Ladders.LinkedListLadder;

public class MergeTwoLists {
	/**
	 * @param ListNode
	 *            l1 is the head of the linked list
	 * @param ListNode
	 *            l2 is the head of the linked list
	 * @return: ListNode head of linked list
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode pre_head = new ListNode(-1);
		
		ListNode loop1 = l1, loop2 = l2, loop = pre_head;
		while(loop1 != null && loop2 != null){
			if(loop1.val <= loop2.val){
				loop.next = loop1;
				loop1 = loop1.next;
			}else{
				loop.next = loop2;
				loop2 = loop2.next;
			}
			loop = loop.next;
		}
		while(loop1 != null){
			loop.next = loop1;
			loop1 = loop1.next;
			loop = loop.next;
		}
		while(loop2 != null){
			loop.next = loop2;
			loop2 = loop2.next;
			loop = loop.next;
		}		
		return pre_head.next;
	}
}
