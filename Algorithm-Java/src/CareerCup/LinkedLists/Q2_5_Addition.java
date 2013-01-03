/**
 * Sanqiang Zhao Www.131X.Com Jan 2, 2013
 */
package CareerCup.LinkedLists;

import Util.LinkedListNode;

public class Q2_5_Addition {

    public LinkedListNode<Integer> add2(LinkedListNode<Integer> left, LinkedListNode<Integer> right, int carry) {
        int sum = carry;
        if (left != null) {
            sum += left.Data;
        }
        if (right != null) {
            sum += right.Data;
        }
        int digit = sum % 10;
        int next_carry = sum / 10;
        LinkedListNode<Integer> node = new LinkedListNode<>(digit);
        if (next_carry > 0 || left != null || right != null) {
            LinkedListNode<Integer> next = add2(left.Next, right.Next, next_carry);
            node.Next = next;
        }
        return node;
    }

    public LinkedListNode<Integer> add1(LinkedListNode<Integer> left, LinkedListNode<Integer> right) {
        int l_length = left.getLength();
        int r_length = right.getLength();
        if (l_length >= r_length) {
            int count = l_length - r_length;
            right = padEmplty(right, count);
        } else {
            int count = r_length - l_length;
            left = padEmplty(left, count);
        }
        Wrapper wr = addHelper(left, right);
        if (wr.carry > 0) {
            LinkedListNode<Integer> node = new LinkedListNode<>(wr.carry);
            node.Next = wr.node;
            return node;
        } else {
            return wr.node;
        }
    }

    private Wrapper addHelper(LinkedListNode<Integer> left, LinkedListNode<Integer> right) {
        if (left == null || right == null) {
            return new Wrapper(null, 0);
        }
        Wrapper wr = addHelper(left.Next, right.Next);
        int sum = left.Data + right.Data + wr.carry;
        int digit = sum % 10;
        int carry = sum / 10;
        LinkedListNode<Integer> node = new LinkedListNode<>(digit);
        node.Next = wr.node;
        return new Wrapper(node, carry);
    }

    class Wrapper {

        int carry;
        LinkedListNode<Integer> node = null;

        public Wrapper(LinkedListNode<Integer> _node, int _carry) {
            this.node = _node;
            this.carry = _carry;
        }
    }

    private LinkedListNode<Integer> padEmplty(LinkedListNode<Integer> head, int count) {
        while (count-- > 0) {
            LinkedListNode<Integer> node = new LinkedListNode<>(0);
            node.Next = head;
            head = node;
        }
        return head;
    }

    public static void main(String[] args) {
        Q2_5_Addition q25 = new Q2_5_Addition();
        LinkedListNode<Integer> left = LinkedListNode.getSampleLinkedList2();
        LinkedListNode<Integer> right = LinkedListNode.getSampleLinkedList2();
        LinkedListNode<Integer> head1 = q25.add1(left, right);
        head1.print();
        LinkedListNode<Integer> head2 = q25.add2(left, right, 0);
        head2.print();
    }
}
