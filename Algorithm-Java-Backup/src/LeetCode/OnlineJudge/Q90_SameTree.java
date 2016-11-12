/**
 * Sanqiang Zhao Www.131X.Com Dec 24, 2012
 */
package LeetCode.OnlineJudge;

import Util.BinaryTreeNode;

public class Q90_SameTree {

    public static void main(String[] args) {
    }

    public boolean isSameTreeMy(BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q) {
        if (p == null) {
            return false;
        }
        if (p.Data == q.Data && isSameTreeMyHelper(p, q)) {
            return true;
        }
        return isSameTreeMy(p.Left, q) || isSameTreeMy(p.Right, q);
    }

    private boolean isSameTreeMyHelper(BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q) {
        if (p == null && q == null) {
            return true;
        } else if ((p == null && q != null) || (q == null && p == null)) {
            return false;
        } else {
            if (p.Data != q.Data) {
                return false;
            }
            return isSameTreeMyHelper(p.Left, q.Left) && isSameTreeMyHelper(p.Right, q.Right);
        }
    }
}
