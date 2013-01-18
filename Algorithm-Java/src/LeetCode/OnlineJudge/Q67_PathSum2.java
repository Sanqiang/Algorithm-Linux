/**
 * Sanqiang Zhao Www.131X.Com Dec 23, 2012
 */
package LeetCode.OnlineJudge;

import Util.BinaryTreeNode;
import java.util.ArrayList;

public class Q67_PathSum2 {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.getSampleTree();
        ArrayList<ArrayList<Integer>> solution = new Q67_PathSum2().pathSumMy(root, 12);
        for (ArrayList<Integer> arrayList : solution) {
            for (Integer integer : arrayList) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> pathSumMy(BinaryTreeNode<Integer> root, int sum) {
        ArrayList<ArrayList<Integer>> solution = new ArrayList<>();
        int height = root.getHeight();
        RCHelper(root, new int[height], solution, sum, 0);
        return solution;
    }

    private void RCHelper(BinaryTreeNode<Integer> head, int[] record, ArrayList<ArrayList<Integer>> solution, int sum, int level) {
        if (head == null) {
            return;
        }
        record[level] = head.Data;
        int count = sum;
        for (int i = level; i >= 0; i--) {
            count -= record[i];
            if (count == 0) {
                //find it
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j = i; j <= level; j++) {
                    temp.add(record[j]);
                }
                solution.add(temp);
            }
        }

        RCHelper(head.Left, record, solution, sum, level + 1);
        RCHelper(head.Right, record, solution, sum, level + 1);
    }
}
