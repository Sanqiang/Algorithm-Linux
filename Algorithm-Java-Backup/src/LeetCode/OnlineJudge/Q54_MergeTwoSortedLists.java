/**
 * Sanqiang Zhao Www.131X.Com Dec 22, 2012
 */
package LeetCode.OnlineJudge;

import Util.LinkedListNode;

public class Q54_MergeTwoSortedLists {

    public static void main(String[] args) {
        LinkedListNode<Integer> l1 = LinkedListNode.getSampleLinkedList();
        LinkedListNode<Integer> l2 = LinkedListNode.getSampleLinkedList2();
        LinkedListNode<Integer> l = new Q54_MergeTwoSortedLists().mergeTwoListsMy(l1, l2);
        l.print();
    }

    public LinkedListNode<Integer> mergeTwoListsMy(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        LinkedListNode<Integer> head = null;
        if (l1 != null && l2 != null) {
            if (l1.Data <= l2.Data) {
                head = l1;
                l1 = l1.Next;
            } else {
                head = l2;
                l2 = l2.Next;
            }
        } else if (l2 != null) {
            head = l2;
            l2 = l2.Next;
        } else if (l1 != null) {
            head = l1;
            l1 = l1.Next;
        }
        head.Next = mergeTwoListsMy(l1, l2);
        return head;
    }
}
