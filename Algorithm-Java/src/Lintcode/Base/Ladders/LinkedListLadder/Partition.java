package Lintcode.Base.Ladders.LinkedListLadder;

public class Partition {
	/**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        
        ListNode left_head = new ListNode(-1), right_head = new ListNode(-1);
        ListNode temp = head, left_temp = left_head, right_temp = right_head;
        while(temp != null){
        	if(temp.val < x){
        		left_temp.next = temp;
        		left_temp = left_temp.next;
        	}else{
        		right_temp.next = temp;
        		right_temp = right_temp.next;
        	}
        	
        	temp = temp.next;
        }
        
        left_temp.next = right_head.next;
        right_temp.next = null;
        
        return left_head.next;
        
    }
}
