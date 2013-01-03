/**
 * Sanqiang Zhao Www.131X.Com Jan 2, 2013
 */
package CareerCup.LinkedLists;

import Util.LinkedListNode;

public class Q2_4_PartitionList {

    LinkedListNode<Integer> partition2(LinkedListNode<Integer> head, int pivot) {
        LinkedListNode<Integer> Left = null, Right = null, cur = head, next = cur.Next;
        while (cur != null) {
            next = cur.Next;
            int val = cur.Data;
            if (val <= pivot) {
                if (Left == null) {
                    Left = cur;
                    Left.Next = null;
                } else {
                    cur.Next = Left;
                    Left = cur;
                }
            } else {
                if (Right == null) {
                    Right = cur;
                    Right.Next = null;
                } else {
                    cur.Next = Right;
                    Right = cur;
                }
            }
            cur = next;
        }
        LinkedListNode<Integer> Connecter = Left;
        while (Connecter.Next != null) {
            Connecter = Connecter.Next;
        }
        System.out.println("Pivot:" + Connecter.Data);
        Connecter.Next = Right;
        return Left;
    }

    LinkedListNode<Integer> partition1(LinkedListNode<Integer> head, int pivot) {
        LinkedListNode<Integer> LeftStart = null, LeftEnd = null, RightStart = null, RightEnd = null, cur = head, next = cur.Next;
        while (cur != null) {
            next = cur.Next;
            int val = cur.Data;
            if (val <= pivot) {
                if (LeftStart == null || LeftEnd == null) {
                    LeftStart = cur;
                    LeftEnd = cur;
                } else {
                    LeftEnd.Next = cur;
                    LeftEnd = cur;
                }
            } else {
                if (RightStart == null || RightEnd == null) {
                    RightStart = cur;
                    RightEnd = cur;
                } else {
                    cur.Next = RightStart;
                    RightStart = cur;
                }
            }
            cur = next;
        }
        if (RightEnd != null) {
            RightEnd.Next = null;
        }
        if (LeftEnd != null) {
            LeftEnd.Next = RightStart;
        }
        if (LeftStart != null) {
            return LeftStart;
        } else {
            return RightStart;
        }
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = LinkedListNode.getSampleLinkedList5();
        head.print();

        Q2_4_PartitionList q24 = new Q2_4_PartitionList();
        //LinkedListNode<Integer> head1 = q24.partition1(head, 4);
        //head1.print();
        LinkedListNode<Integer> head2 = q24.partition2(head, 3);
        head2.print();
    }
}
