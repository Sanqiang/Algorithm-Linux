package Lintcode.Base.Ladders.LinkedListLadder;

public class DetectCycle {
	/**
	 * @param head:
	 *            The first node of linked list.
	 * @return: The node where the cycle begins. if there is no cycle, return
	 *          null
	 */
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				break;
			}
		}

		if (slow == fast) {
			ListNode temp = head;
			while (temp != null && slow != null) {
				temp = temp.next;
				slow = slow.next;
				if (temp == slow) {
					return temp;
				}
			}
			return null;

		} else {
			return null;
		}

	}
}
