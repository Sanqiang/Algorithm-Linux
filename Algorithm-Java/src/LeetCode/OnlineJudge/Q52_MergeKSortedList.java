/**
 * Sanqiang Zhao Www.131X.Com Dec 22, 2012
 */
package LeetCode.OnlineJudge;

import Util.LinkedListNode;
import java.util.ArrayList;

public class Q52_MergeKSortedList {

    public LinkedListNode<Integer> mergeKLists(ArrayList<LinkedListNode<Integer>> lists) {
        LinkedListNode<Integer> pre = null, head = null;
        while (true) {
            LinkedListNode<Integer> MinNode = null;
            int min_index = 0, i, length = lists.size();

            boolean exit = true;
            for (LinkedListNode<Integer> node : lists) {
                if (node != null) {
                    exit = false;
                }
            }
            if (exit) {
                break;
            }

            for (i = 0; i < length; ++i) {
                LinkedListNode<Integer> node = lists.get(i);
                if (node != null) {
                    if (MinNode == null) {
                        MinNode = node;
                        min_index = i;
                    } else if (node.Data < MinNode.Data) {
                        MinNode = node;
                        min_index = i;
                    }
                }
            }
            if (pre == null) {
                pre = MinNode;
                head = MinNode;
            } else {
                pre.Next = MinNode;
                pre = MinNode;
            }
            LinkedListNode<Integer> next = lists.get(min_index).Next;
            lists.set(min_index, next);
        }
        return head;
    }

    public static void main(String[] args) {
        ArrayList<LinkedListNode<Integer>> lists = new ArrayList<>();
        lists.add(LinkedListNode.getSampleLinkedList());
        lists.add(LinkedListNode.getSampleLinkedList2());
        lists.add(LinkedListNode.getSampleLinkedList3());
        LinkedListNode<Integer> solution = new Q52_MergeKSortedList().mergeKLists(lists);
        LinkedListNode<Integer> cur = solution;
        while (cur != null) {
            System.out.println(cur.Data);
            cur = cur.Next;
        }

    }
}
