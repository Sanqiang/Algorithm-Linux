/**
 * Sanqiang Zhao Www.131X.Com Dec 22, 2012
 */
package LeetCode.OnlineJudge;

import Util.LinkedListNode;

public class Q63_PartitionList {

    public static void main(String[] args) {
        LinkedListNode<Integer> list = LinkedListNode.getSampleLinkedList7();
        LinkedListNode<Integer> list2 = new Q63_PartitionList().partition(list, 1);
        list2.print();
    }

    public LinkedListNode<Integer> partition(LinkedListNode<Integer> head, int x) {
        LinkedListNode<Integer> runner = head, next = head.Next, LS = null, LE = null, RS = null, RE = null;
        while (runner != null) {
            next = runner.Next;

            if (runner.Data <= x) {
                if (LS == null) {
                    LS = runner;
                    LE = runner;
                } else {
                    LE.Next = runner;
                    LE = runner;
                }
            } else {
                if (RS == null) {
                    RS = runner;
                    RE = runner;
                } else {
                    runner.Next = RS;
                    RS = runner;
                }
            }

            runner = next;
        }
        if (LE != null) {
            LE.Next = RS;
        }
        if (RE != null) {
            RE.Next = null;
        }
        return LS;
    }
}
