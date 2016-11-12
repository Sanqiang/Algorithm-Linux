/**
 * Sanqiang Zhao Www.131X.Com Dec 17, 2012
 */
package LeetCode.OnlineJudge;

import Util.BinaryTreeNode;
import java.util.ArrayList;

public class Q12_BinaryTreeLevelOrderTraversal {
    
    public ArrayList<ArrayList<Integer>> levelOrder(BinaryTreeNode<Integer> root) {
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
        levelOrderHelper(solutions, 0, root);
        return solutions;
    }
    
    private void levelOrderHelper(ArrayList<ArrayList<Integer>> solutions, int level, BinaryTreeNode<Integer> head) {
        if (head == null) {
            return;
        }
        ArrayList<Integer> list = null;
        if (solutions.size() - 1 < level) {
            list = new ArrayList<>();
            solutions.add(list);
        } else {
            list = solutions.get(level);
        }
        list.add(head.Data);
        levelOrderHelper(solutions, level + 1, head.Left);
        levelOrderHelper(solutions, level + 1, head.Right);
    }
    
    public static void main(String[] args) {
        Q12_BinaryTreeLevelOrderTraversal q12  = new Q12_BinaryTreeLevelOrderTraversal();
        BinaryTreeNode<Integer> root = BinaryTreeNode.getSampleTree();
        ArrayList<ArrayList<Integer>> solutions = q12.levelOrder(root);
        for (ArrayList<Integer> arrayList : solutions) {
            for (Integer integer : arrayList) {
                System.out.print(integer+",");
            }
            System.out.println();
        }
    }
}
