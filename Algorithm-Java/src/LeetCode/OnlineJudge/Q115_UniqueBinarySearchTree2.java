/**
 * Sanqiang Zhao Www.131X.Com Dec 26, 2012
 */
package LeetCode.OnlineJudge;

import Util.BinaryTreeNode;
import java.util.ArrayList;

public class Q115_UniqueBinarySearchTree2 {

    public ArrayList<BinaryTreeNode<Integer>> generateTrees(int n) {
        return generateTreesHelper(1, n);
    }

    private ArrayList<BinaryTreeNode<Integer>> generateTreesHelper(int s, int e) {
        ArrayList<BinaryTreeNode<Integer>> solution = new ArrayList<>();
        if (s > e) {
            solution.add(null);
            return solution;
        }
        BinaryTreeNode<Integer> LeftChild = null, RightChild = null;
        for (int i = s; i <= e; i++) {
            ArrayList<BinaryTreeNode<Integer>> Lefts = generateTreesHelper(s, i - 1);
            ArrayList<BinaryTreeNode<Integer>> Rights = generateTreesHelper(i + 1, e);
            for (BinaryTreeNode<Integer> LeftNode : Lefts) {
                for (BinaryTreeNode<Integer> RightNode : Rights) {
                    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(i);
                    root.Left = LeftNode;
                    root.Right = RightNode;
                    solution.add(root);
                }
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int n  = 3;
        ArrayList<BinaryTreeNode<Integer>> solution = new Q115_UniqueBinarySearchTree2().generateTrees(n);
    }
}
