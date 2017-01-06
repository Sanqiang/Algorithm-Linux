package Lintcode.Base.Ladders.LinkedListLadder;

public class NthToLast {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        ListNode slow = head, fast = head;
        for(int i = 0; i < n; ++i){
        	fast = fast.next;
        }
        
        while(fast != null){
        	fast = fast.next;
        	slow = slow.next;
        }
        
        return slow;
    }
}
