/**
 * Sanqiang Zhao Www.131X.Com Jan 24, 2013
 */
package haimenboy;

import Util.BinaryTreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class Q9_PrintTreeByLevel {

    public void printQueue(BinaryTreeNode<Integer> head, int desire) {
        Queue<BinaryTreeNode<Integer>> nodes = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        if (head != null) {
            nodes.add(head);
            levels.add(0);
        }
        while (!nodes.isEmpty()) {
            BinaryTreeNode<Integer> node = nodes.poll();
            int level = levels.poll();
            if (level == desire) {
                System.out.println(node.Data);
            }
            if (node.Left != null) {
                nodes.add(node.Left);
                levels.add(level + 1);
            }
            if (node.Right != null) {
                nodes.add(node.Right);
                levels.add(level + 1);
            }
        }
    }
    
    public void printRC(BinaryTreeNode<Integer> head, int desire, int level) {
        if (head == null) {
            return;
        }
        if (desire == level) {
            System.out.println(head.Data);
        }
        printRC(head.Left, desire, level+1);
        printRC(head.Right, desire, level+1);
    }

    public static void main(String[] args) {
        Q9_PrintTreeByLevel q9 = new Q9_PrintTreeByLevel();
        BinaryTreeNode<Integer> head = BinaryTreeNode.getSampleTree();
        q9.printQueue(head, 2);
        q9.printRC(head, 2, 0);
    }
}
