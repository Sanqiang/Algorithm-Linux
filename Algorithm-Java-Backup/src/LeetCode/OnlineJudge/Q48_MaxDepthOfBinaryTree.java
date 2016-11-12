/**
 * Sanqiang Zhao Www.131X.Com Dec 21, 2012
 */
package LeetCode.OnlineJudge;

import Util.BinaryTreeNode;

public class Q48_MaxDepthOfBinaryTree {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.getSampleTree();
        int depth = new Q48_MaxDepthOfBinaryTree().maxDepthMy(root);
        System.out.println(depth);
    }

    //my way
    public int maxDepthMy(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepthMy(root.Left);
        int r = maxDepthMy(root.Right);
        return Math.max(l, r) + 1;
    }
}
