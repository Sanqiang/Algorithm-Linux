/**
 * Sanqiang Zhao Www.131X.Com Dec 23, 2012
 */
package LeetCode.OnlineJudge;

import Util.BinaryTreeNode;

public class Q75_RecoverBinarySearchTree {

    public void recoverTree(BinaryTreeNode<Integer> root) {
        Wrapper wr1 = new Wrapper();
        recoverTreeFindL(root, wr1);
        Wrapper wr2 = new Wrapper();
        recoverTreeFindR(root, wr2);
        System.out.println(wr1.node.Data + "<->" + wr2.node.Data);
        int temp = wr1.node.Data;
        wr1.node.Data = wr2.node.Data;
        wr2.node.Data = temp;
    }

    private void recoverTreeFindL(BinaryTreeNode<Integer> root, Wrapper wr) {
        if (root == null) {
            return;
        }
        recoverTreeFindL(root.Left, wr);
        if (wr.node == null) {
            wr.node = root;
        } else {
            if (root.Data < wr.node.Data) {
                return;
            }
            wr.node = root;
        }
        recoverTreeFindL(root.Right, wr);
    }

    private void recoverTreeFindR(BinaryTreeNode<Integer> root, Wrapper wr) {
        if (root == null) {
            return;
        }
        recoverTreeFindR(root.Right, wr);
        if (wr.node == null) {
            wr.node = root;
        } else {
            if (root.Data > wr.node.Data) {
                return;
            }
            wr.node = root;
        }
        recoverTreeFindR(root.Left, wr);
    }

    class Wrapper {

        BinaryTreeNode<Integer> node;

        public Wrapper(BinaryTreeNode<Integer> _node) {
            this.node = _node;
        }

        public Wrapper() {
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.getSampleTree();
        root.Left.Data = 17;
        root.Right.Right.Data = 5;
        new Q75_RecoverBinarySearchTree().recoverTree(root);
    }
}
