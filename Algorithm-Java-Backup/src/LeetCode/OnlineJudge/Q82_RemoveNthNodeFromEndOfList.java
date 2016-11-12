/**
 * Sanqiang Zhao Www.131X.Com Dec 24, 2012
 */
package LeetCode.OnlineJudge;

import Util.LinkedListNode;

public class Q82_RemoveNthNodeFromEndOfList {

    public LinkedListNode<Integer> removeNthFromEnd(LinkedListNode<Integer> head, int n) {
        LinkedListNode<Integer> left = head;
        LinkedListNode<Integer> right = head;
        int i;
        for (i = 0; i < n + 1; ++i) {
            right = right.Next;
        }
        while (right != null) {
            left = left.Next;
            right = right.Next;
        }
        left.Next = left.Next.Next;
        return head;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = LinkedListNode.getSampleLinkedList();
        head.print();
        LinkedListNode<Integer> head2 = new Q82_RemoveNthNodeFromEndOfList().removeNthFromEndMy(head, 7);
        head2.print();
    }

    public LinkedListNode<Integer> removeNthFromEndMy(LinkedListNode<Integer> head, int n) {
        LinkedListNode<Integer> left = head;
        LinkedListNode<Integer> right = head;
        for (int i = 0; i < n + 1; i++) {
            right = right.Next;
            if (right == null) {
                return head.Next;
            }
        }
        while (right != null) {
            left = left.Next;
            right = right.Next;
        }
        if (left != null && left.Next != null) {
            left.Next = left.Next.Next;
        }
        return head;
    }
}
