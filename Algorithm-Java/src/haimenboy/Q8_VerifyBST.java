/**
 * Sanqiang Zhao Www.131X.Com Jan 24, 2013
 */
package haimenboy;

import Util.BinaryTreeNode;

public class Q8_VerifyBST {
    
    public boolean verify(BinaryTreeNode<Integer> head, int min, int max) {
        if (head == null) {
            return true;
        }
        if (head.Data <= max && head.Data >= min) {
            return verify(head.Left, min, head.Data) && verify(head.Right, head.Data, max);
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.getSampleTree();
        boolean reuslt = new Q8_VerifyBST().verify(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(reuslt);
    }
}
