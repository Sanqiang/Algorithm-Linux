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

    public int getLength() {
        int count = 0;
        LinkedListNode<V> runner = this;
        while (runner != null) {
            ++count;
            runner = runner.Next;
        }
        return count;
    }

    public void print() {
        LinkedListNode<V> runner = this;
        while (runner != null) {
            System.out.println(runner.Data);
            runner = runner.Next;
        }
        System.out.println();
    }

    /*public LinkedListNode(V _data, LinkedListNode<V> _next) {
     this.Data = _data;
     this.Next = _next;
     } */
    public static LinkedListNode<Integer> getSampleLinkedList() {
        LinkedListNode<Integer> n1 = new LinkedListNode<>(2);
        LinkedListNode<Integer> n2 = new LinkedListNode<>(5, n1);
        LinkedListNode<Integer> n3 = new LinkedListNode<>(7, n2);
        LinkedListNode<Integer> n4 = new LinkedListNode<>(10, n3);
        LinkedListNode<Integer> n5 = new LinkedListNode<>(12, n4);
        LinkedListNode<Integer> n6 = new LinkedListNode<>(15, n5);
        LinkedListNode<Integer> n7 = new LinkedListNode<>(17, n6);
        return n1;
    }

    public static LinkedListNode<Integer> getSampleLinkedList2() {
        LinkedListNode<Integer> n1 = new LinkedListNode<>(1);
        LinkedListNode<Integer> n2 = new LinkedListNode<>(2, n1);
        LinkedListNode<Integer> n3 = new LinkedListNode<>(3, n2);
        LinkedListNode<Integer> n4 = new LinkedListNode<>(4, n3);
        LinkedListNode<Integer> n5 = new LinkedListNode<>(5, n4);
        LinkedListNode<Integer> n6 = new LinkedListNode<>(6, n5);
        LinkedListNode<Integer> n7 = new LinkedListNode<>(7, n6);
        LinkedListNode<Integer> n8 = new LinkedListNode<>(8, n7);
        return n1;
    }

    public static LinkedListNode<Integer> getSampleLinkedList3() {
        LinkedListNode<Integer> n1 = new LinkedListNode<>(11);
        LinkedListNode<Integer> n2 = new LinkedListNode<>(12, n1);
        LinkedListNode<Integer> n3 = new LinkedListNode<>(13, n2);
        LinkedListNode<Integer> n4 = new LinkedListNode<>(14, n3);
        LinkedListNode<Integer> n5 = new LinkedListNode<>(15, n4);
        LinkedListNode<Integer> n6 = new LinkedListNode<>(16, n5);
        LinkedListNode<Integer> n7 = new LinkedListNode<>(17, n6);
        return n1;
    }

    public static LinkedListNode<Integer> getSampleLinkedList4() {
        LinkedListNode<Integer> n1 = new LinkedListNode<>(0);
        LinkedListNode<Integer> n2 = new LinkedListNode<>(1, n1);
        LinkedListNode<Integer> n3 = new LinkedListNode<>(1, n2);
        LinkedListNode<Integer> n4 = new LinkedListNode<>(2, n3);
        LinkedListNode<Integer> n5 = new LinkedListNode<>(2, n4);
        LinkedListNode<Integer> n6 = new LinkedListNode<>(2, n5);
        LinkedListNode<Integer> n7 = new LinkedListNode<>(3, n6);
        return n1;
    }

    public static LinkedListNode<Integer> getSampleLinkedList5() {
        LinkedListNode<Integer> n1 = new LinkedListNode<>(0);
        LinkedListNode<Integer> n2 = new LinkedListNode<>(1, n1);
        LinkedListNode<Integer> n3 = new LinkedListNode<>(3, n2);
        LinkedListNode<Integer> n4 = new LinkedListNode<>(5, n3);
        LinkedListNode<Integer> n5 = new LinkedListNode<>(2, n4);
        LinkedListNode<Integer> n6 = new LinkedListNode<>(4, n5);
        LinkedListNode<Integer> n7 = new LinkedListNode<>(6, n6);
        return n1;
    }

    public static LinkedListNode<Integer> getSampleLinkedList6() {
        LinkedListNode<Integer> n1 = new LinkedListNode<>(0);
        LinkedListNode<Integer> n2 = new LinkedListNode<>(1, n1);
        LinkedListNode<Integer> n3 = new LinkedListNode<>(2, n2);
        LinkedListNode<Integer> n4 = new LinkedListNode<>(3, n3);
        LinkedListNode<Integer> n5 = new LinkedListNode<>(4, n4);
        LinkedListNode<Integer> n6 = new LinkedListNode<>(5, n5);
        LinkedListNode<Integer> n7 = new LinkedListNode<>(6, n6);
        LinkedListNode<Integer> n8 = new LinkedListNode<>(7, n7);
        n8.Next = n3;
        return n1;
    }

        public static LinkedListNode<Integer> getSampleLinkedList7() {
        LinkedListNode<Integer> n1 = new LinkedListNode<>(0);
        LinkedListNode<Integer> n2 = new LinkedListNode<>(1, n1);
        LinkedListNode<Integer> n3 = new LinkedListNode<>(2, n2);
        LinkedListNode<Integer> n4 = new LinkedListNode<>(3, n3);
        LinkedListNode<Integer> n5 = new LinkedListNode<>(3, n4);
        LinkedListNode<Integer> n6 = new LinkedListNode<>(2, n5);
        LinkedListNode<Integer> n7 = new LinkedListNode<>(1, n6);
        LinkedListNode<Integer> n8 = new LinkedListNode<>(0, n7);
        return n1;
    }
    
    public static void main(String[] args) {
        LinkedListNode<Integer> n = getSampleLinkedList();

    }
}
