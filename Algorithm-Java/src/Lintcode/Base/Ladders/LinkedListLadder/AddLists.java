package Lintcode.Base.Ladders.LinkedListLadder;

public class AddLists {
	/**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        ListNode pre_head = new ListNode(-1), loop = pre_head;
        int carry = 0;
    	while(l1 != null && l2 != null){
        	int v1 = l1.val, v2 = l2.val;
        	int val = (carry + v1 + v2) % 10;
        	carry = (carry + v1 + v2) / 10;
        	ListNode temp = new ListNode(val);
        	loop.next = temp;
        	loop = loop.next;
        	l1 = l1.next;
        	l2 = l2.next;
    	}
    	
    	while(l1 != null){
        	int val = (carry + l1.val) % 10;
        	carry = (carry + l1.val) / 10; 
        	ListNode temp = new ListNode(val);
        	loop.next = temp;
    		loop = loop.next;
    		l1 = l1.next;
    	}
    	while(l2 != null){
        	int val = (carry + l2.val) % 10;
        	carry = (carry + l2.val) / 10; 
        	ListNode temp = new ListNode(val);
        	loop.next = temp;
    		loop = loop.next;
    		l2 = l2.next;
    	}
    	
    	if(carry > 0){
        	ListNode temp = new ListNode(carry);
        	loop.next = temp;
    	}
    	
    	return pre_head.next;
    }
}
