/**
 * Sanqiang Zhao Www.131X.Com Dec 18, 2012
 */
package LeetCode.OnlineJudge;

import Util.BinaryTreeNode;

public class Q21_ConstructBinaryTreeFromPreMidTraversal {

    public BinaryTreeNode<Integer> buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        return buildTreeHelper(0, length - 1, 0, length - 1, preorder, inorder);
    }

    private BinaryTreeNode<Integer> buildTreeHelper(int pre_s, int pre_e, int in_s, int in_e, int[] preorder, int[] inorder) {
        if (in_s > in_e) {
            return null;
        }
        int root_val = preorder[pre_s];
        int i = in_s;
        for (i = in_s; i <= in_e; ++i) {
            if (inorder[i] == root_val) {
                break;
            }
        }
        int left_len = i - in_s;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(root_val);
        root.Left = buildTreeHelper(pre_s + 1, pre_s + left_len, in_s, i - 1, preorder, inorder);
        root.Right = buildTreeHelper(pre_s + left_len+1, pre_e, i + 1, in_e, preorder, inorder);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {2, 1, 4, 3, 5};
        BinaryTreeNode<Integer> root = new Q21_ConstructBinaryTreeFromPreMidTraversal().buildTree(preorder, inorder);
        System.out.print(root);
    }
}
