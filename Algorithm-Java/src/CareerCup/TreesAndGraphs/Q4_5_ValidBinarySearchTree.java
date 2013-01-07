/**
 * Sanqiang Zhao Www.131X.Com Jan 4, 2013
 */
package CareerCup.TreesAndGraphs;

import Util.BinaryTreeNode;

public class Q4_5_ValidBinarySearchTree {

    public boolean isSearchTreeS(BinaryTreeNode<Integer> root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.Data > min || root.Data < max) {
            return false;
        }
        boolean result = true;
        result &= isSearchTreeS(root.Right, root.Data, max) && isSearchTreeS(root.Left, min, root.Data);
        return result;
    }

    public boolean isSearchTree(BinaryTreeNode<Integer> root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.Left != null) {
            if (min > root.Left.Data || root.Data < root.Left.Data) {
                return false;
            }
        } else if (root.Right != null) {
            if (max < root.Right.Data || root.Data > root.Right.Data) {
                return false;
            }
        }
        boolean result = true;
        result &= isSearchTree(root.Right, root.Data, max) && isSearchTree(root.Left, min, root.Data);
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> bstree = BinaryTreeNode.getSampleTree();
        BinaryTreeNode<Integer> ubstree = BinaryTreeNode.getSampleTree2();
        Q4_5_ValidBinarySearchTree q45 = new Q4_5_ValidBinarySearchTree();
        System.out.println(q45.isSearchTree(bstree, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(q45.isSearchTree(ubstree, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
