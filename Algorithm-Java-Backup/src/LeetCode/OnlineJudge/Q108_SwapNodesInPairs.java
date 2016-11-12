/**
 * Sanqiang Zhao Www.131X.Com Dec 26, 2012
 */
package LeetCode.OnlineJudge;

import Util.LinkedListNode;

public class Q108_SwapNodesInPairs {

    public LinkedListNode<Integer> swapPairs(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> FakeHead = new LinkedListNode<>(0);
        FakeHead.Next = head;
        LinkedListNode<Integer> l1 = head, l2 = head, pre = FakeHead, cur = head, NewHead = head.Next;
        while (cur != null && cur.Next != null) {
            l1 = cur;
            l2 = cur.Next;
            cur = cur.Next.Next;
            l2.Next = l1;
            l1.Next = cur;
            pre.Next = l2;
            pre = l1;
        }
        return NewHead;
    }

    public LinkedListNode<Integer> swapPairsEx(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> cur = head, pre = null, next = head.Next, NewHead = head.Next, LastEnd = null;
        int count = 1;
        while (cur != null) {
            if (count++ % 2 == 0) {
                cur.Next = pre;
                LastEnd = pre;
            } else {
                if (LastEnd != null) {
                    LastEnd.Next = next;
                }
            }
            pre = cur;
            cur = next;
            if (next != null) {
                next = next.Next;
            }
        }
        if (count % 2 == 1) {
            LastEnd.Next = null;
        } else {
            LastEnd.Next = pre;
        }
        return NewHead;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = LinkedListNode.getSampleLinkedList();
        head.print();
        System.out.println("-=-=-=-=-=-=-");
        LinkedListNode<Integer> NewHead = new Q108_SwapNodesInPairs().swapPairsMy(head);
        NewHead.print();
    }

    public LinkedListNode<Integer> swapPairsSample(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> sent = new LinkedListNode<Integer>(0);
        sent.Next = head;

        if (head == null) {
            return null;
        }
        LinkedListNode<Integer> cur = head, pre = sent, next = head.Next;
        while (next != null) {
            cur.Next = next.Next;
            next.Next = cur;
            pre.Next = next;

            pre = next;
            next = cur.Next;
            if (next != null) {
                pre = cur;
                cur = next;
                next = next.Next;
            }
        }


        return sent.Next;
    }

    public LinkedListNode<Integer> swapPairsMy(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> sent = new LinkedListNode<Integer>(0);
        sent.Next = head;

        if (head == null) {
            return null;
        }
        LinkedListNode<Integer> pre = sent, cur = head, next = head.Next;
        while (next != null) {
            cur.Next = next.Next;
            next.Next = cur;
            pre.Next = next;

            pre = cur;
            cur = cur.Next;
            if (cur != null) {
                next = cur.Next;
            } else {
                break;
            }
        }
        return sent.Next;
    }
}
