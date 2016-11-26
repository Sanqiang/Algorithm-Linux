package Lintcode.Intensive.L4;

public class HasCycle {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		
		ListNode slow_node = head, fast_node = head;
		while (true) {
			slow_node = slow_node.next;
			if (slow_node == null) {
				return false;
			}
			fast_node = fast_node.next;
			if (fast_node == null) {
				return false;
			}
			fast_node = fast_node.next;
			if (fast_node == null) {
				return false;
			}
			
			if (slow_node == fast_node) {
				return true;
			}
		}
	}
	
    public ListNode detectCycle(ListNode head) {  
    	if (head == null) {
    		return null;
    	}
    	
    	ListNode slow_node = head, fast_node = head;
		while (true) {
			slow_node = slow_node.next;
			if (slow_node == null) {
				return null;
			}
			fast_node = fast_node.next;
			if (fast_node == null) {
				return null;
			}
			fast_node = fast_node.next;
			if (fast_node == null) {
				return null;
			}
			
			if (slow_node == fast_node) {
				break;
			}
		}
    	
		while (head == slow_node.next) {
			head = head.next;
			slow_node = slow_node.next;
		}
		
    	return head;
    }
}
