package Question2_1;

import java.util.Hashtable;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Question {

	public static void deleteDupsA(LinkedListNode n) {
		Hashtable table = new Hashtable();
		LinkedListNode previous = null;
		while (n != null) {
			if (table.containsKey(n.data)) {
				previous.next = n.next;
			} else {
				table.put(n.data, true);
				previous = n;
			}
			n = n.next;
		}
	}
	
	public static int count = 0;
	
	public static void deleteDupsC(LinkedListNode head) {
		if (head == null) return;
		LinkedListNode previous = head;
		LinkedListNode current = previous.next;
		while (current != null) {
			// Look backwards for dups, and remove any that you see.
			LinkedListNode runner = head;
			while (runner != current) { 
				
				if (runner.data == current.data) {
					LinkedListNode tmp = current.next;
					previous.next = tmp;
					current = tmp;
					/* We know we can’t have more than one dup preceding
					 * our element since it would have been removed 
					 * earlier. */
				    break;
				}
				count++;
				runner = runner.next;
			}
			
			/* If runner == current, then we didn’t find any duplicate 
			 * elements in the previous for loop.  We then need to 
			 * increment current.  
			 * If runner != current, then we must have hit the ‘break’ 
			 * condition, in which case we found a dup and current has
			 * already been incremented.*/
			if (runner == current) {
				previous = current;
				count++;
		        current = current.next;
			}
		}
	}
	public static int count2 = 0;
	
	public static void deleteDupsB(LinkedListNode head) {
		if (head == null) return;
		
		LinkedListNode current = head;
		while (current != null) {
			/* Remove all future nodes that have the same value */
			LinkedListNode runner = current;
			while (runner.next != null) { 
				
				if (runner.next.data == current.data) {
					count2++;
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			count2++;
			current = current.next;
		}
	}	
	
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(1000, 0, 2);
	//	System.out.println(head.printForward());
		deleteDupsC(head);
		//System.out.println(head.printForward());
		System.out.println(count);
	}
}
