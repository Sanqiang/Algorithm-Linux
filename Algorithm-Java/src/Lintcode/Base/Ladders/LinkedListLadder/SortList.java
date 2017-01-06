package Lintcode.Base.Ladders.LinkedListLadder;

public class SortList {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMiddle(head);

        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);

        return mergeList(left, right);
    }
    
	ListNode mergeList(ListNode head1, ListNode head2) {
		ListNode pre_head = new ListNode(-1);
		ListNode loop = pre_head;
		while (head1 != null && head2 != null) {
			if(head1.val <= head2.val){
				loop.next = head1;
				head1 = head1.next;
			}else{
				loop.next = head2;
				head2 = head2.next;
			}
			
			loop = loop.next;
		}
		while (head1 != null) {
			loop.next = head1;
			head1 = head1.next;
			loop = loop.next;
		} 
		while (head2 != null) {
			loop.next = head2;
			head2 = head2.next;
			loop = loop.next;
		} 
		return pre_head.next;
	}

	ListNode findMiddle(ListNode head) {
		ListNode slow = head, fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
