/**
 * Sanqiang Zhao Www.131X.Com Dec 23, 2012
 */
package LeetCode.OnlineJudge;

import Util.BinaryTreeNode;
import java.util.ArrayList;

public class Q66_PathSum {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.getSampleTree();
        boolean find = new Q66_PathSum().hasPathSum(root, 121);
        System.out.println(find);
    }

    public boolean hasPathSum(BinaryTreeNode<Integer> root, int sum) {
        int height = root.getHeight();
        RCHelper(root, new int[height], sum, 0);
        return find;

    }
    static boolean find = false;

    private void RCHelper(BinaryTreeNode<Integer> head, int[] record, int sum, int level) {
        if (find) {
            return;
        }
        if (head == null) {
            return;
        }

        record[level] = head.Data;
        int count = sum;
        for (int i = level; i >= 0; i--) {
            count -= record[i];
            if (count == 0) {
                find = true;
                return;
            }
        }

        RCHelper(head.Left, record, sum, level + 1);
        RCHelper(head.Right, record, sum, level + 1);
    }
}
