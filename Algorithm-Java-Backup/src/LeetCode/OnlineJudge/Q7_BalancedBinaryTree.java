/**
 * Sanqiang Zhao Www.131X.Com Dec 17, 2012
 */
package LeetCode.OnlineJudge;

import Util.BinaryTreeNode;

public class Q7_BalancedBinaryTree {

    public int isBalancedHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int l = isBalancedHelper(root.Left);
        if (l == -1) {
            return -1;
        }
        int r = isBalancedHelper(root.Right);
        if (r == -1) {
            return -1;
        }
        int dis = Math.abs(l - r);
        if (dis > 1) {
            return -1;
        }
        return 1 + dis;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.getSampleTree3();
        int result = new Q7_BalancedBinaryTree().isBalancedHelper(root);
        System.out.println(result);
    }
}
