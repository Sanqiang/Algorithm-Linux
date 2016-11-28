package Lintcode.Base.L6;

import java.util.HashMap;

public class CopyRandomList {
	/**
	 * @param head:
	 *            The head of linked list with a random pointer.
	 * @return: A new head of a deep copy of the list.
	 */
	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	}

	public RandomListNode copyRandomList(RandomListNode head) {
		HashMap<RandomListNode, RandomListNode> mapper = new HashMap<>();
		RandomListNode pre_head = new RandomListNode(0), temp_new = pre_head;
		RandomListNode temp = head, new_node;

		while (temp != null) {
			if (mapper.containsKey(temp)) {
				new_node = mapper.get(temp);
			} else {
				new_node = new RandomListNode(temp.label);
				mapper.put(temp, new_node);
			}
			temp_new.next = new_node;

			if (temp.random != null) {
				if (mapper.containsKey(temp.random)) {
					new_node.random = mapper.get(temp.random);
				} else {
					new_node.random = new RandomListNode(temp.random.label);
					mapper.put(temp.random, new_node.random);
				}
			}

			temp_new = new_node;
			temp = temp.next;
		}

		return pre_head.next;
	}
}
