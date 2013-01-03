/**
 * Sanqiang Zhao Www.131X.Com Jan 2, 2013
 */
package CareerCup.LinkedLists;

import Util.LinkedListNode;
import java.util.HashSet;

public class Q2_1_RemoveDuplicate {

    void removeDuplicate(LinkedListNode<Integer> head)
    {
        LinkedListNode<Integer> loop = head.Next, pre = head;
        HashSet<Integer> tab = new HashSet<>();
        while (loop != null) {            
            if (tab.contains(loop.Data)) {
                pre.Next = loop.Next;
            }else{
                tab.add(loop.Data);
                pre = loop;
            }
            loop = loop.Next;
        }
    }
    
    void removeDuplicate2(LinkedListNode<Integer> head)
    {
        LinkedListNode<Integer> loop = head.Next, pre = head, runner = head;
        while (loop != null) {            
            runner = loop.Next;
            pre = loop;
            while (runner!= null) {                
                if (runner.Data == loop.Data) {
                    pre.Next = runner.Next;
                }else{
                    pre = runner;
                }
                runner = runner.Next;
            }
            loop = loop.Next;
        }
    }
    
    public static void main(String[] args) {
        LinkedListNode<Integer> head = LinkedListNode.getSampleLinkedList4();
        //new Q2_1_RemoveDuplicate().removeDuplicate(head);
        new Q2_1_RemoveDuplicate().removeDuplicate2(head);
        head.print();
    }
}
