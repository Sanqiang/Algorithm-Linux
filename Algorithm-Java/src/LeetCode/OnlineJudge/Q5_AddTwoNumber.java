/**
 * Sanqiang Zhao Www.131X.Com Dec 17, 2012
 */
package LeetCode.OnlineJudge;

import Util.LinkedListNode;

public class Q5_AddTwoNumber {

    public LinkedListNode<Integer> addTwoNumbers(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2, int carry) {
        if (carry == 0 && l1 == null & l2 == null) {
            return null;
        }
        int sum = carry;
        if (l1 != null) {
            sum += l1.Data;
        }
        if (l2 != null) {
            sum += l2.Data;
        }
        int digit = sum % 10;
        int next_carry = sum / 10;
        LinkedListNode<Integer> node = new LinkedListNode<>(digit);
        LinkedListNode<Integer> next_node = addTwoNumbers(l1 != null ? l1.Next : null, l2 != null ? l2.Next : null, next_carry);
        node.Next = next_node;
        return node;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> l1 = LinkedListNode.getSampleLinkedList2();
        LinkedListNode<Integer> l2 = LinkedListNode.getSampleLinkedList2();
        LinkedListNode<Integer> add = new Q5_AddTwoNumber().addTwoNumbers(l1, l2, 0);
        add.print();
    }
}
