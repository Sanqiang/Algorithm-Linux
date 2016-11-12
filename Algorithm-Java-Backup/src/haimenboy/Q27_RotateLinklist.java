/**
 * Sanqiang Zhao Www.131X.Com Jan 27, 2013
 */
package haimenboy;

import Util.LinkedListNode;

public class Q27_RotateLinklist {

    LinkedListNode<Integer> rotate(LinkedListNode<Integer> head, int k) {
        LinkedListNode<Integer> new_end = null, new_start = null, runner = head;
        for (int i = 0; i < k - 1; i++) {
            runner = runner.Next;
        }
        new_end = runner;
        new_start = new_end.Next;
        while (runner.Next != null) {
            runner = runner.Next;
        }
        runner.Next = head;
        new_end.Next = null;
        return new_start;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = LinkedListNode.getSampleLinkedList();
        head.print();
        LinkedListNode<Integer> new_head = new Q27_RotateLinklist().rotate(head, 2);
        new_head.print();
    }
}
