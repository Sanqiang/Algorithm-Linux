package Lintcode.Base.Ladders.LinkedListLadder;

public class RotateRight {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        
        int cnt = 0;
        ListNode loop = head;
        while(loop != null){
        	loop = loop.next;
        	++cnt;
        }
        n %= cnt;
        
        ListNode slow = head, fast = head;
        for(int i = 0; i < n; ++i){
        	fast = fast.next;
        }
        while(fast.next != null){
        	slow = slow.next;
        	fast = fast.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        
        return head;
    }
}
