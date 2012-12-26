/**
 * Sanqiang Zhao Www.131X.Com Dec 26, 2012
 */
package LeetCode.OnlineJudge;

import Util.BinaryTreeNode;

public class Q109_SymmetricTree {

    public boolean isSymmetric(BinaryTreeNode<Integer> root) {
        if (root.Left == null && root.Right == null) {
            return true;
        } else if (root.Left != null && root.Right != null) {
            return root.Left.Data == root.Right.Data && isSymmetric(root.Left) && isSymmetric(root.Right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.getSampleTree();
        boolean result = new Q109_SymmetricTree().isSymmetric(root);
        System.out.println(result);
        BinaryTreeNode<Integer> root2 = BinaryTreeNode.getSampleTree2();
        boolean result2 = new Q109_SymmetricTree().isSymmetric(root2);
        System.out.println(result2);
    }
}
