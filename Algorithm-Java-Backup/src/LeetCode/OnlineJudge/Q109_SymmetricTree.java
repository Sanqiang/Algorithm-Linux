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
        boolean result = new Q109_SymmetricTree().isSymmetricMy(root, root);
        System.out.println(result);
        BinaryTreeNode<Integer> root2 = BinaryTreeNode.getSampleTree2();
        boolean result2 = new Q109_SymmetricTree().isSymmetricMy(root2, root2);
        System.out.println(result2);
    }

    //most correct one
    public boolean isSymmetricMy(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> root2) {
        if (root == null && root2 == null) {
            return true;
        } else if ((root == null && root2 != null) || (root != null && root2 == null)) {
            return false;
        } else if (root.Data != root2.Data) {
            return false;
        } else {
            return isSymmetricMy(root.Left, root2.Right) && isSymmetricMy(root.Right, root2.Left);
        }
    }
}
