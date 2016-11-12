/**
 * Sanqiang Zhao Www.131X.Com Jan 2, 2013
 */
package CareerCup.LinkedLists;

import Util.LinkedListNode;

public class Q2_6_FindBeginning {

    LinkedListNode<Integer> findBegin(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> fast = head, slow = head;
        do {
            if (fast == null || slow == null || fast.Next == null) {
                System.out.println("No Loop!!!");
                return null;
            }
            fast = fast.Next.Next;
            slow = slow.Next;
        } while (fast != slow);
        slow = head;
        while (slow != fast) {
            slow = slow.Next;
            fast = fast.Next;
        }
        return fast;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = LinkedListNode.getSampleLinkedList6();
        LinkedListNode<Integer> begin = new Q2_6_FindBeginning().findBegin(head);
        System.out.println(begin.Data);
    }
}
