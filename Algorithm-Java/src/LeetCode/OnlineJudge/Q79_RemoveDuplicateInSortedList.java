/**
 * Sanqiang Zhao Www.131X.Com Dec 24, 2012
 */
package LeetCode.OnlineJudge;

import Util.LinkedListNode;
import java.util.HashMap;
import java.util.HashSet;

public class Q79_RemoveDuplicateInSortedList {

    public LinkedListNode<Integer> deleteDuplicates(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> runner = head, next = null;
        /* Note here: Cannot update more than one
         * while (runner != null) {
         next = runner.Next;
         if (next != null && next.Data == runner.Data) {
         runner.Next = next.Next;
         }
         runner = next;
         }*/
        while (runner != null) {
            next = runner.Next;
            while (next != null && next.Data == runner.Data) {
                next = next.Next;
            }
            runner.Next = next;
            runner = next;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> n1 = LinkedListNode.getSampleLinkedList4();
        new Q79_RemoveDuplicateInSortedList().deleteDuplicatesMy(n1);
        n1.print();
    }

    public LinkedListNode<Integer> deleteDuplicatesMy(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> runner = head, newhead = head, loop;
        
        while (runner != null) {
            loop = runner.Next;
            while (loop != null && loop.Data == runner.Data) {
                loop = loop.Next;
            }
            runner.Next = loop;
            runner = loop;
        }
        
        return newhead;
    }
}
