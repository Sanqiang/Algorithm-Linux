/**
 * Sanqiang Zhao Www.131X.Com Jan 2, 2013
 */
package CareerCup.LinkedLists;

import Util.LinkedListNode;

public class Q2_3_DeleteNode {

    void delete(LinkedListNode<Integer> node)
    {
        if (node.Next == null) {
            System.out.println("No ways");
            //throw new Exception("UnSupported");
            throw  new RuntimeException("UnSupported");
        }else{
            node.Data = node.Next.Data;
            node.Next = node.Next.Next;
        }
    }
    
    public static void main(String[] args) {
    }
}
