/**
 * Sanqiang Zhao Www.131X.Com Jan 5, 2013
 */
package CareerCup.TreesAndGraphs;

import Util.BinaryTreeNode;

public class Q4_8_SubTree {

    public boolean isSubtree(BinaryTreeNode<Integer> large, BinaryTreeNode<Integer> small) {
        if (large == null || small == null) {
            return false;
        }
        boolean result = false;
        if (large.Data == small.Data) {
            result |= match(large, small);
            //alternative
            if (match(large, small)) {
                return true;
            }
            //alternative
        }
        boolean l = isSubtree(large.Left, small);
        if (l) {
            return l;
        }
        boolean r = isSubtree(large.Right, small);
        if (r) {
            return r;
        }
        return result;
    }

    private boolean match(BinaryTreeNode<Integer> large, BinaryTreeNode<Integer> small) {
        if (large == null && small == null) {
            return true;
        } else if (large == null) {
            return false;
        } else if (small == null) {
            return true;
        }
        boolean result = true;
        boolean l = match(large.Left, small.Left);
        if (!l) {
            return l;
        }
        boolean r = match(large.Right, small.Right);
        if (!r) {
            return r;
        }
        if (large.Data != small.Data) {
            return false;
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> large = BinaryTreeNode.getSampleTree();
        BinaryTreeNode<Integer> small = large.Left;
        BinaryTreeNode<Integer> small2 = BinaryTreeNode.getSampleTree2();
        Q4_8_SubTree q48 = new Q4_8_SubTree();
        boolean result = q48.isSubtree(large, small2);
        System.out.println(result);
    }
}
