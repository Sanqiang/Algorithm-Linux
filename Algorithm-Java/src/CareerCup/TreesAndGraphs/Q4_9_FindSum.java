/**
 * Sanqiang Zhao Www.131X.Com Jan 5, 2013
 */
package CareerCup.TreesAndGraphs;

import Util.BinaryTreeNode;

public class Q4_9_FindSum {

    private int[] array;

    public void findsum(BinaryTreeNode<Integer> root, int sum) {
        array = new int[root.getHeight()];
        findsumHelper(root, sum, 0);
    }

    public void findsumHelper(BinaryTreeNode<Integer> root, int sum, int level) {
        if (root == null) {
            return;
        }
        array[level] = root.Data;
        int count = sum;
        for (int i = level; i >= 0; --i) {
            count -= array[i];
            if (count == 0) {
                print(array, i, level);
            }
        }
        findsumHelper(root.Left, sum, level + 1);
        findsumHelper(root.Right, sum, level + 1);

    }

    private void print(int[] array, int s, int e) {
        for (int i = s; i <= e; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.getSampleTree();
        Q4_9_FindSum q49 = new Q4_9_FindSum();
        q49.findsum(root, 17);
    }
}
