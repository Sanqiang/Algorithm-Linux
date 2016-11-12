/**
 * Sanqiang Zhao Www.131X.Com Dec 24, 2012
 */
package LeetCode.OnlineJudge;

import Util.LinkedListNode;

public class Q80_RemoveDuplicateInSortedList2 {

    public LinkedListNode<Integer> deleteDuplicates(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> solution = new LinkedListNode<>(0);
        LinkedListNode<Integer> runner = head, pre = solution;
        solution.Next = head;
        while (runner != null) {
            boolean dup = false;
            while (runner.Next != null && runner.Next.Data == runner.Data) {
                dup = true;
                runner = runner.Next;
            }
            if (dup) {
                runner = runner.Next;
                pre.Next = runner;
            } else {
                pre = runner;
                runner = runner.Next;
            }
        }
        return solution.Next;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> n1 = LinkedListNode.getSampleLinkedList4();
        n1.print();
        System.out.println("-=-=-=-=-=-=-");
        LinkedListNode<Integer> n2 = new Q80_RemoveDuplicateInSortedList2().deleteDuplicatesMy(n1);
        n2.print();
    }

    public LinkedListNode<Integer> deleteDuplicatesMy(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> runner = head, newhead = new LinkedListNode<>(Integer.MIN_VALUE), loop, last = newhead;
        newhead.Next = runner;
        boolean duplicate = false;
        while (runner != null) {
            duplicate = false;

            loop = runner.Next;
            while (loop != null && loop.Data == runner.Data) {
                duplicate = true;
                loop = loop.Next;
            }

            if (duplicate) {
                last.Next = loop;
                runner = loop;
            } else {
                last = runner;
                runner = runner.Next;
            }
        }

        return newhead.Next;
    }
}
