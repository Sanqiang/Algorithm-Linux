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
        LinkedListNode<Integer> solution = new Q52_MergeKSortedList().mergeKListsMy(lists);
        LinkedListNode<Integer> cur = solution;
        while (cur != null) {
            System.out.println(cur.Data);
            cur = cur.Next;
        }
    }

    public LinkedListNode<Integer> mergeKListsMy(ArrayList<LinkedListNode<Integer>> lists) {
        int len = lists.size();
        boolean pass = true;
        LinkedListNode<Integer> head = null, runner = null;
        while (pass) {
            pass = false;
            LinkedListNode<Integer> smallest = new LinkedListNode<>(Integer.MAX_VALUE);
            int smallest_ind = 0;
            for (int i = 0; i < len; i++) {
                if (lists.get(i) != null) {
                    pass = true;
                }
                if (lists.get(i) != null && lists.get(i).Data < smallest.Data) {
                    smallest = lists.get(i);
                    smallest_ind = i;
                }
            }
            if (pass) {
                if (runner == null) {
                    runner = smallest;
                } else {
                    runner.Next = smallest;
                }
                runner = smallest;
                if (head == null) {
                    head = smallest;
                }
                lists.set(smallest_ind, lists.get(smallest_ind).Next);
            }
        }
        return head;
    }

    private LinkedListNode<Integer> setSmallest(LinkedListNode<Integer> a, LinkedListNode<Integer> b) {
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }
        return a.Data >= b.Data ? b : a;
    }
}
