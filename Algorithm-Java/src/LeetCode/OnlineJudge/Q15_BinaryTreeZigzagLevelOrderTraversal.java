/**
 * Sanqiang Zhao Www.131X.Com Dec 17, 2012
 */
package LeetCode.OnlineJudge;

import Util.BinaryTreeNode;
import java.util.ArrayList;
import java.util.Iterator;

public class Q15_BinaryTreeZigzagLevelOrderTraversal {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(BinaryTreeNode<Integer> root) {
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();
        int height = getHeight(root), i = 0;
        for (; i < height; ++i) {
            solutions.add(new ArrayList<Integer>());
        }
        zigzagLevelOrderHelper(root, 0, solutions);
        return solutions;
    }

    private void zigzagLevelOrderHelper(BinaryTreeNode<Integer> root, int level, ArrayList<ArrayList<Integer>> solutions) {
        if (root == null) {
            return;
        }
        zigzagLevelOrderHelper(root.Left, level + 1, solutions);
        zigzagLevelOrderHelper(root.Right, level + 1, solutions);

        ArrayList<Integer> list = solutions.get(level);
        if (level % 2 == 0) {
            list.add(root.Data);
        } else {
            list.add(0, root.Data);
        }
    }

    private int getHeight(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int l = getHeight(root.Left);
        int r = getHeight(root.Right);
        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.getSampleTree();
        ArrayList<ArrayList<Integer>> solutions = new Q15_BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root);
        for (Iterator<ArrayList<Integer>> it = solutions.iterator(); it.hasNext();) {
            ArrayList<Integer> arrayList = it.next();
            System.out.print("[");
            for (Iterator<Integer> it1 = arrayList.iterator(); it1.hasNext();) {
                Integer integer = it1.next();
                System.out.print(integer + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
