/**
 * Sanqiang Zhao Www.131X.Com Dec 24, 2012
 */
package LeetCode.OnlineJudge;

import Util.LinkedListNode;

public class Q85_ReverseLinkedList2 {

    public LinkedListNode<Integer> reverseBetween(LinkedListNode<Integer> head, int m, int n) {
        int i = 1;
        LinkedListNode<Integer> start_l = null, start_r = null, end_l = null, end_r = null, runner = head, last = null, next = head.Next;
        while (next != null) {
            if (i == m) {
                start_l = last;
                end_l = runner;
            }
            if (i == n) {
                start_r = runner;
                end_r = next;
            }
            if (i > m && i <= n) {
                runner.Next = last;
            }
            last = runner;
            runner = next;
            next = next.Next;
            ++i;
        }
        start_l.Next = start_r;
        end_l.Next = end_r;
        return head;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> root = LinkedListNode.getSampleLinkedList();
        root.print();
        System.out.println("-=-=-=-=-=-=-");
        LinkedListNode<Integer> root2 = new Q85_ReverseLinkedList2().reverseBetweenMy(root, 1, 4);
        root2.print();
    }

    //most correct one
    public LinkedListNode<Integer> reverseBetweenMy(LinkedListNode<Integer> head, int m, int n) {
        LinkedListNode<Integer> solution = new LinkedListNode<>(0), cur = head, pre = solution, next = head.Next, LS = null, LE = null;
        solution.Next = head;
        int a = m, b = n;
        while (--a > 0) {
            next = cur.Next;
            pre = cur;
            cur = next;
        }
        LS = pre;
        LE = cur;
        while (b-- >= m) {
            next = cur.Next;
            cur.Next = pre;
            pre = cur;
            cur = next;
        }
        LS.Next = pre;
        LE.Next = cur;
        return solution.Next;
    }
}
