package Lintcode.Base.L6;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import Lintcode.Base.L6.DeleteDuplicates.ListNode;

public class MergeKLists {
	class PriorityComp implements Comparator<ListNode> {

		@Override
		public int compare(ListNode left, ListNode right) {
			if (left == null) {
				return 1;
			} else if (right == null) {
				return -1;
			}
			return left.val - right.val;
		}

	}

	/**
	 * @param lists:
	 *            a list of ListNode
	 * @return: The head of one sorted list.
	 */
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}

		ListNode pre_head = new ListNode(0), temp = pre_head;
		PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.size(), new PriorityComp());
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
            	queue.add(lists.get(i));
            }
        }

		while (!queue.isEmpty()) {
			ListNode node = queue.poll();

			temp.next = node;
			temp = node;

			if (node.next != null) {
				queue.add(node.next);
				node = node.next;
			}
		}

		return pre_head.next;
	}
}
