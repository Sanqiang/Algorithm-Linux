/**
 * Sanqiang Zhao Www.131X.Com Dec 18, 2012
 */
package Util;

public class LinkedListNode<V> {
    
    public V Data;
    public LinkedListNode<V> Next;
    
    public LinkedListNode(V _data) {
        this.Data = _data;
        this.Next = null;
    }
    
    public LinkedListNode(V _data, LinkedListNode<V> _last) {
        this.Data = _data;
        _last.Next = this;
    }
    
    /*public LinkedListNode(V _data, LinkedListNode<V> _next) {
        this.Data = _data;
        this.Next = _next;
    } */   
    
    public static LinkedListNode<Integer> getSampleLinkedList() {
        LinkedListNode<Integer> n1 = new LinkedListNode<>(2);
        LinkedListNode<Integer> n2 = new LinkedListNode<>(5,n1);
        LinkedListNode<Integer> n3 = new LinkedListNode<>(7,n2);
        LinkedListNode<Integer> n4 = new LinkedListNode<>(10,n3);
        LinkedListNode<Integer> n5 = new LinkedListNode<>(12,n4);
        LinkedListNode<Integer> n6 = new LinkedListNode<>(15,n5);
        LinkedListNode<Integer> n7 = new LinkedListNode<>(17,n6);
        return n1;
    }
    
    public static void main(String[] args) {
        LinkedListNode<Integer> n = getSampleLinkedList();
        
    }
}
