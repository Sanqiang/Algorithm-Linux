/**
 * Sanqiang Zhao Www.131X.Com Jan 27, 2013
 */
package haimenboy;

import Util.LinkedListNode;

public class Q25_MidLinkList {
    
    int len = 0;
    int cur = 0;
    
    void getMid(LinkedListNode<Integer> head) {
        if (head != null) {
            ++len;
            getMid(head.Next);
            ++cur;
        }
        if (cur * 2 == len || cur * 2 == len + 1) {
            System.out.println(head.Data);
        }
    }
    
    public static void main(String[] args) {
        LinkedListNode<Integer> head = LinkedListNode.getSampleLinkedList();
        new Q25_MidLinkList().getMid(head);
    }
}
