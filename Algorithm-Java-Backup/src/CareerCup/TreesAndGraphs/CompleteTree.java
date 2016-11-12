/**
 * Sanqiang Zhao Www.131X.Com Mar 17, 2013
 */
package CareerCup.TreesAndGraphs;

import Util.BinaryTreeNode;

public class CompleteTree {

    //level init as 0
    public boolean verify(BinaryTreeNode<Integer> root, int level) {
        if (root == null) {
            return true;
        }
        boolean l = verify(root.Left, level + 1);
        if (!l) {
            return false;
        }
        boolean r = verify(root.Right, level + 1);
        if (!r) {
            return false;
        }
        if (root.Left == null || root.Right == null) {
            if (MaxLevel == -1) {
                MaxLevel = level;
            } else {
                if (MaxLevel == level && !LoopFlag) {
                    return true;
                } else if (MaxLevel - 1 == level) {
                    LoopFlag = true;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return l && r;
    }
    static int MaxLevel = -1;
    static boolean LoopFlag = false;

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.getSampleTree5();
        boolean result = new CompleteTree().verify(root, 0);
        System.out.println(result);
    }
}
