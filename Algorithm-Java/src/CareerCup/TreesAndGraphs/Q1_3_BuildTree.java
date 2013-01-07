/**
 * Sanqiang Zhao Www.131X.Com Jan 4, 2013
 */
package CareerCup.TreesAndGraphs;

import Util.BinaryTreeNode;

public class Q1_3_BuildTree {

    public BinaryTreeNode<Integer> build(int[] arr, int s, int e) {
        if (s > e) {
            return null;
        }
        int m = s + (e - s) / 2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[m]);
        root.Left = build(arr, s, m - 1);
        root.Right = build(arr, m + 1, e);
        return root;
    }

    public static void main(String[] args) {
    }
}
