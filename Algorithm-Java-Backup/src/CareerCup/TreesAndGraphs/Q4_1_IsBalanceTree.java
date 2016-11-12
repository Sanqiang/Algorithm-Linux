/**
 * Sanqiang Zhao Www.131X.Com Jan 4, 2013
 */
package CareerCup.TreesAndGraphs;

import LeetCode.OnlineJudge.Q41_LengthOfLastWord;
import Util.BinaryTreeNode;

public class Q4_1_IsBalanceTree {

    public boolean isBalance(BinaryTreeNode<Integer> root) {
        int dif = isBalanceHelper(root);
        return dif != -1;
    }

    public int isBalanceHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int l = isBalanceHelper(root.Left);
        if (l == -1) {
            return -1;
        }
        int r = isBalanceHelper(root.Right);
        if (r == -1) {
            return -1;
        }
        int dif = Math.abs(l - r);
        if (dif > 2) {
            return -1;
        }
        return dif + 1;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.getSampleTree();
        Q4_1_IsBalanceTree q41 = new Q4_1_IsBalanceTree();
        System.out.println(q41.isBalanceHelper(root));
    }
}
