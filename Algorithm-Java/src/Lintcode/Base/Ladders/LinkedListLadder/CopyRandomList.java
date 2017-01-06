package Lintcode.Base.Ladders.LinkedListLadder;

import java.util.HashMap;

public class CopyRandomList {
	/**
	 * @param head:
	 *            The head of linked list with a random pointer.
	 * @return: A new head of a deep copy of the list.
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode loop = head, dhead = new RandomListNode(head.label);
		map.put(loop, dhead);
		while (loop != null) {
			if (!map.containsKey(loop)) {
				map.put(loop, new RandomListNode(loop.label));
			}
			RandomListNode dloop = map.get(loop);
			if (loop.next != null) {
				if (!map.containsKey(loop.next)) {
					map.put(loop.next, new RandomListNode(loop.next.label));
				}
				RandomListNode dloop_next = map.get(loop.next);
				dloop.next = dloop_next;
			}
			if (loop.random != null) {
				if (!map.containsKey(loop.random)) {
					map.put(loop.random, new RandomListNode(loop.random.label));
				}
				RandomListNode dloop_rand = map.get(loop.random);
				dloop.random = dloop_rand;
			}

			loop = loop.next;
		}

		return dhead;
	}

	public RandomListNode copyRandomList_noHM(RandomListNode head) {
		if (head == null) {
			return null;
		}

		RandomListNode loop = head;
		
		//scan next
		while (loop != null) {
			RandomListNode next = loop.next;
			RandomListNode dloop = new RandomListNode(loop.label);
			loop.next = dloop;
			dloop.next = next;
			loop = next;
		}
		
		//scan random
		loop = head;
		while (loop != null) {
			if(loop.random != null){
				loop.next.random = loop.random.next;
			}
			loop = loop.next.next;
		}
		
		//split
		RandomListNode dhead = head.next;;
		loop = head;
		while (loop != null) {
			RandomListNode dloop = loop.next, next = loop.next.next;
			if(loop.next.next != null){
				loop.next = loop.next.next;
				dloop.next = dloop.next.next;
			}
			loop = next;
		}
		
		return dhead;
	}
}
