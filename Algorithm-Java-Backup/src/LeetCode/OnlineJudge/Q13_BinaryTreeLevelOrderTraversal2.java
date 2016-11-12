/**
 * Sanqiang Zhao Www.131X.Com Dec 17, 2012
 */
package LeetCode.OnlineJudge;

import Util.BinaryTreeNode;
import java.util.ArrayList;

public class Q13_BinaryTreeLevelOrderTraversal2 {

    public ArrayList<ArrayList<Integer>> levelOrderBottom(BinaryTreeNode<Integer> root) {
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
        int height = root.getHeight();
        for (int i = 0; i < height; i++) {
            solutions.add(new ArrayList<Integer>());
        }
        levelOrderHelper(solutions, 0, height, root);
        return solutions;
    }

    private void levelOrderHelper(ArrayList<ArrayList<Integer>> solutions, int level, int height, BinaryTreeNode<Integer> head) {
        if (head == null) {
            return;
        }
        ArrayList<Integer> list = solutions.get(height - 1 - level);
        list.add(head.Data);
        levelOrderHelper(solutions, level + 1, height, head.Left);
        levelOrderHelper(solutions, level + 1, height, head.Right);
    }

    public static void main(String[] args) {
        Q13_BinaryTreeLevelOrderTraversal2 q13 = new Q13_BinaryTreeLevelOrderTraversal2();
        BinaryTreeNode<Integer> root = BinaryTreeNode.getSampleTree();
        ArrayList<ArrayList<Integer>> solutions = q13.levelOrderBottom(root);
        for (ArrayList<Integer> arrayList : solutions) {
            for (Integer integer : arrayList) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }
}
