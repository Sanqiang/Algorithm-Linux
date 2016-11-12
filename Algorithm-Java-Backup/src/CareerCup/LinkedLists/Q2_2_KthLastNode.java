/**
 * Sanqiang Zhao Www.131X.Com Jan 2, 2013
 */
package CareerCup.LinkedLists;

import Util.LinkedListNode;

public class Q2_2_KthLastNode {

    LinkedListNode<Integer> getKthLastNode3(LinkedListNode<Integer> head, int k) {
        LinkedListNode<Integer> left = head, right = head;
        while (k-- > 0) {
            right = right.Next;
        }
        while (right != null) {
            left = left.Next;
            right = right.Next;
        }
        return left;
    }
    static int count = 1;

    LinkedListNode<Integer> getKthLastNode2(LinkedListNode<Integer> head, int k) {
        if (head == null) {
            return null;
        }
        LinkedListNode<Integer> node = getKthLastNode2(head.Next, k);
        if (count <= k) {
            ++count;
            return head;
        }
        return node;
    }

    LinkedListNode<Integer> getKthLastNode(LinkedListNode<Integer> head, Wrapper wr, int k) {
        if (head == null) {
            return null;
        }
        if (wr == null) {
            wr = new Wrapper(1);
        }
        LinkedListNode<Integer> node = getKthLastNode(head.Next, wr, k);
        if (wr.count <= k) {
            ++wr.count;
            return head;
        }
        return node;
    }

    class Wrapper {

        int count;

        public Wrapper(int _count) {
            this.count = _count;
        }
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = LinkedListNode.getSampleLinkedList2();
        Q2_2_KthLastNode q2 = new Q2_2_KthLastNode();
        LinkedListNode<Integer> node1 = q2.getKthLastNode(head, null, 2);
        System.out.println(node1.Data);
        LinkedListNode<Integer> node2 = q2.getKthLastNode2(head, 2);
        System.out.println(node2.Data);
        LinkedListNode<Integer> node3 = q2.getKthLastNode3(head, 2);
        System.out.println(node3.Data);
    }
}
