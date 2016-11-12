/**
 * Sanqiang Zhao Www.131X.Com Jan 24, 2013
 */
package haimenboy;

import Util.BinaryTreeNode;

public class Q15_ClosestInBST {

    int find(BinaryTreeNode<Integer> head, int target) {
        return target + findHelper(head, target);
    }

    int findHelper(BinaryTreeNode<Integer> head, int target) {
        if (head == null) {
            return Integer.MAX_VALUE;
        }
        if (head.Data < target) {
            return smaller(head.Data - target, findHelper(head.Right, target));
        } else if (head.Data > target) {
            return smaller(head.Data - target, findHelper(head.Left, target));
        } else {
            return 0;
        }
    }

    int smaller(int a, int b) {
        if (Math.abs(a) > Math.abs(b)) {
            return b;
        } else {
            return a;
        }
    }

    public static void main(String[] args) {
        Q15_ClosestInBST q15 = new Q15_ClosestInBST();
        BinaryTreeNode<Integer> head = BinaryTreeNode.getSampleTree();
        int val = q15.find(head, 9);
        System.out.println(val);
    }
}
