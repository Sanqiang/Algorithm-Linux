/**
 * Sanqiang Zhao Www.131X.Com Jan 23, 2013
 */
package haimenboy;

import Util.LinkedListNode;

public class Q1_ReverseLinkedlist {

    LinkedListNode<Integer> new_head = null;

    LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
        new_head = null;
        reverseRC(head);
        head.Next = null;
        return new_head;
    }

    LinkedListNode<Integer> reverseRC(LinkedListNode<Integer> head) {
        if (head.Next == null || head == null) {
            new_head = head;
            return head;
        }
        LinkedListNode<Integer> node = reverseRC(head.Next);
        node.Next = head;
        return head;
    }

    LinkedListNode<Integer> reverseSample(LinkedListNode<Integer> head) {
        if (head.Next == null || head == null) {
            return head;
        }
        LinkedListNode<Integer> remaining = reverseSample(head.Next);
        LinkedListNode<Integer> cur = remaining;
        while (cur.Next != null) {            
            cur = cur.Next;
        }
        cur.Next = head;
        head.Next = null;
        return remaining;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = LinkedListNode.getSampleLinkedList();
        head.print();
        LinkedListNode<Integer> reverse = new Q1_ReverseLinkedlist().reverse(head);
        reverse.print();
    }
}
