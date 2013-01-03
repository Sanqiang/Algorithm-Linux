/**
 * Sanqiang Zhao Www.131X.Com Jan 2, 2013
 */
package CareerCup.LinkedLists;

import Util.LinkedListNode;
import java.util.Stack;

public class Q2_7_IsPalindrome {

    boolean isPalindrome2(LinkedListNode<Integer> head) {
        Stack<Integer> stack = new Stack<>();
        LinkedListNode<Integer> fast = head, slow = head;
        while (fast != null && fast.Next != null) {
            stack.push(slow.Data);
            slow = slow.Next;
            fast = fast.Next.Next;
        }
        if (fast != null) {
            slow = slow.Next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != slow.Data) {
                return false;
            }
            slow = slow.Next;
        }
        return true;
    }

    boolean isPalindrome(LinkedListNode<Integer> head) {
        int length = head.getLength();
        Wrapper wr = isPalindrome(head, length);
        return wr.match;
    }

    Wrapper isPalindrome(LinkedListNode<Integer> head, int length) {
        if (length == 2) {
            return new Wrapper(head.Next.Next, head.Data == head.Next.Data);
        } else if (length == 1) {
            return new Wrapper(head.Next, true);
        } else if (length == 0) {
            return new Wrapper(head, true);
        }
        Wrapper wr = isPalindrome(head.Next, length - 2);
        if (!wr.match || wr.node == null) {
            return wr;
        }
        wr.match = head.Data == wr.node.Data;
        wr.node = wr.node.Next;
        return wr;
    }

    class Wrapper {

        LinkedListNode<Integer> node;
        boolean match;

        public Wrapper(LinkedListNode<Integer> _node, boolean _match) {
            this.match = _match;
            this.node = _node;
        }
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = LinkedListNode.getSampleLinkedList7();
        Q2_7_IsPalindrome q27 = new Q2_7_IsPalindrome();
        boolean result = q27.isPalindrome(head);
        System.out.println(result);
        boolean result2 = q27.isPalindrome2(head);
        System.out.println(result2);
    }
}
