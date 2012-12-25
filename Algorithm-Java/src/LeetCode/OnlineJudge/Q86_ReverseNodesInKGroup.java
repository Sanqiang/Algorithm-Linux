/**
 * Sanqiang Zhao Www.131X.Com Dec 24, 2012
 */
package LeetCode.OnlineJudge;

import Util.LinkedListNode;

public class Q86_ReverseNodesInKGroup {

    public LinkedListNode<Integer> reverseKGroup(LinkedListNode<Integer> head, int k) {
        LinkedListNode<Integer> pre = null, cur = head, next = head.Next;
        int count = 0;
        while (cur != null) {
            cur.Next = pre;
            if (++count == k) {
                break;
            }
            pre = cur;
            cur = next;
            if (next != null) {
                next = next.Next;
            }
        }
        head.Next = next;
        return cur;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = LinkedListNode.getSampleLinkedList();
        head.print();
        System.out.println("-=-=-=-=-=-=-");
        LinkedListNode<Integer> head2 = new Q86_ReverseNodesInKGroup().reverseKGroup(head, 3);
        head2.print();
    }
}
