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
        LinkedListNode<Integer> n2 = new Q80_RemoveDuplicateInSortedList2().deleteDuplicates(n1);
        n2.print();
    }
}
