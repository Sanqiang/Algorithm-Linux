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
        root.Right = buildTreeHelper(pre_s + left_len + 1, pre_e, i + 1, in_e, preorder, inorder);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {2, 1, 4, 3, 5};
        int[] inorder = {1, 2, 3, 4, 5};
        BinaryTreeNode<Integer> root = new Q21_ConstructBinaryTreeFromPreMidTraversal().buildTreeMy(preorder, inorder);
        System.out.print(root);
    }

    //my way
    public BinaryTreeNode<Integer> buildTreeMy(int[] preorder, int[] inorder) {
        int length = inorder.length;
        return buildTreeHelperMy(0, length - 1, 0, length - 1, preorder, inorder);
    }

    private BinaryTreeNode<Integer> buildTreeHelperMy(int pre_s, int pre_e, int in_s, int in_e, int[] preorder, int[] inorder) {
        if (in_s > in_e || pre_s < 0 || pre_e >= inorder.length) {
            return null;
        }
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(preorder[pre_s]);
        int len = 0;
        for (int i = in_s; i <= in_e; i++) {
            if (inorder[i] == preorder[pre_s]) {
                break;
            }
            ++len;
        }
        node.Left = buildTreeHelperMy(pre_s + 1, pre_s + 1 + len - 1, in_s, in_s + len - 1,  preorder,inorder);
        node.Right = buildTreeHelperMy(pre_s + len + 1, pre_e - 1, in_s + len + 1, in_e, preorder,inorder);
        return node;
    }
}
