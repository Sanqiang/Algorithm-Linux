package Lintcode.Base.Ladders.DataStructureLadder;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {
	/**
	 * @param lists:
	 *            a list of ListNode
	 * @return: The head of one sorted list.
	 */
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}

		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new ListNodeComparator());
		for (ListNode node : lists) {
			if (node != null) {
				pq.add(node);
			}
		}

		ListNode pre_head = new ListNode(-1), loop = pre_head;

		while (!pq.isEmpty()) {
			ListNode temp = pq.poll();
			if (temp.next != null) {
				pq.add(temp.next);
			}
			if(temp != null){
			    loop.next = temp;
				loop = loop.next;
			}
		}

		return pre_head.next;
	}

	class ListNodeComparator implements Comparator<ListNode> {

		@Override
		public int compare(ListNode o1, ListNode o2) {
			return o1.val - o2.val;
		}
	}
}
