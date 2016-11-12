/**
 * Sanqiang Zhao Www.131X.Com Jan 4, 2013
 */
package CareerCup.TreesAndGraphs;

import Util.BinaryTreeNode;

public class Q4_7_CommonAncester {

    public BinaryTreeNode<Integer> find(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q) {
        Wrapper wr = findHelper(root, p, q);
        if (wr.find) {
            return wr.node;
        } else {
            return null;
        }
    }

    public Wrapper findHelper(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q) {
        Wrapper wr = new Wrapper();
        if (root == null) {
            if (p == root) {
                wr.node = p;
            } else if (q == root) {
                wr.node = q;
            }
            return wr;
        }
        Wrapper l = findHelper(root.Left, p, q);
        if (l.find) {
            return l;
        }
        Wrapper r = findHelper(root.Right, p, q);
        if (r.find) {
            return r;
        }
        if (l.node != null && r.node != null) {
            wr.node = root;
            wr.find = true;
            return wr;
        } else if (root == p || root == q) {
            wr.find = l.node != null || r.node != null;
            wr.node = root;
        } else {
            wr.find = false;
            if (p == root) {
                wr.node = p;
            } else if (q == root) {
                wr.node = q;
            }
        }
        return wr;
    }

    class Wrapper {

        BinaryTreeNode<Integer> node;
        boolean find;

        public Wrapper() {
        }

        public Wrapper(BinaryTreeNode<Integer> _node, boolean _find) {
            this.node = _node;
            this.find = _find;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.getSampleTree();
        Q4_7_CommonAncester q47 = new Q4_7_CommonAncester();
        BinaryTreeNode<Integer> ancester = q47.find(root, root.Left.Left, root.Left);
        System.out.println(ancester.Data);
    }
}
