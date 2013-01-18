/**
 * Sanqiang Zhao Www.131X.Com Dec 18, 2012
 */
package LeetCode.OnlineJudge;

import Util.BinaryTreeNode;

public class Q23_ConvertArrayToBinaryTree {

    public BinaryTreeNode<Integer> sortedArrayToBST(int[] num, int s, int e) {
        if (s > e) {
            return null;
        }
        int m = s + (e - s) / 2;
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(num[m]);
        node.Left = sortedArrayToBST(num, s, m - 1);
        node.Right = sortedArrayToBST(num, m + 1, e);
        return node;
    }

    public static void main(String[] args) {
    }
}
