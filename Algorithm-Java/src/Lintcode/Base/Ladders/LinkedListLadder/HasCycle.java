package Lintcode.Base.Ladders.LinkedListLadder;

public class HasCycle {
	/**
	 * @param head:
	 *            The first node of linked list.
	 * @return: True if it has a cycle, or false
	 */
	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}

		ListNode slow = head, fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				return true;
			}
		}

		return false;
	}
}
