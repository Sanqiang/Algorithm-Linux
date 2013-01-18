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
        LinkedListNode<Integer> head2 = new Q86_ReverseNodesInKGroup().reverseKGroupMy(head, 3);
        head2.print();
    }

    public LinkedListNode<Integer> reverseKGroupMy(LinkedListNode<Integer> head, int k) {
        LinkedListNode<Integer> pre_head = new LinkedListNode<>(0);
        pre_head.Next = head;
        LinkedListNode<Integer> pre = pre_head, cur = head, next = head.Next;
        while (k-- > 0) {
            next = cur.Next;
            cur.Next = pre;
            pre = cur;
            cur = next;
        }
        pre_head.Next.Next = cur;
        pre_head.Next = pre;
        return pre_head.Next;
    }
}
