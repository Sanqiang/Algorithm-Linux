/**
 * Sanqiang Zhao Www.131X.Com Dec 18, 2012
 */
package LeetCode.OnlineJudge;

import Util.BinaryTreeNode;
import Util.LinkedListNode;

public class Q24_ConvertLinkedListToBinaryTree {

    public BinaryTreeNode<Integer> sortedListToBST(LinkedListNode<Integer> head) {
        int s = 0, e = 0;
        LinkedListNode<Integer> runner = head;
        while (runner != null) {
            ++e;
            runner = runner.Next;
        }
        return sortedListToBSTHelper(new Wrapper(head), s, e - 1);
    }

    private BinaryTreeNode<Integer> sortedListToBSTHelper(Wrapper wr, int s, int e) {
        if (s > e) {
            return null;
        }
        int m = s + (e - s) / 2;
        BinaryTreeNode<Integer> Left = sortedListToBSTHelper(wr, s, m - 1);
        BinaryTreeNode<Integer> parent = new BinaryTreeNode<>(wr.Node.Data);
        parent.Left = Left;
        wr.Node = wr.Node.Next;
        parent.Right = sortedListToBSTHelper(wr, m + 1, e);
        return parent;
    }

    class Wrapper{
        LinkedListNode<Integer> Node;
        public Wrapper(LinkedListNode<Integer> _node)
        {
            this.Node=_node;
        }
    }
    
    public static void main(String[] args) {
        LinkedListNode<Integer> list = LinkedListNode.getSampleLinkedList();
        BinaryTreeNode<Integer> root = new Q24_ConvertLinkedListToBinaryTree().sortedListToBST(list);
    }
}
