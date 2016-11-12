/**
 * Sanqiang Zhao Www.131X.Com Dec 17, 2012
 */
package LeetCode.OnlineJudge;

import Util.BinaryTreeNode;
import java.util.ArrayList;
import java.util.Stack;

public class Q11_BinaryTreeInOrderTraversal {

    public ArrayList<Integer> inorderTraversal(BinaryTreeNode<Integer> root) {
        ArrayList<Integer> solution = new ArrayList<>();
        BinaryTreeNode<Integer> runner = root;
        Stack<BinaryTreeNode<Integer>> s = new Stack<>();
        s.add(runner);
        runner = runner.Left;
        while (!s.isEmpty() || runner != null) {
            while (runner != null) {
                s.add(runner);
                runner = runner.Left;
            }
            if (!s.isEmpty()) {
                runner = s.pop();
            }
            if (runner != null) {
                solution.add(runner.Data);
            }
            runner = runner.Right;
        }
        return solution;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.getSampleTree();
        Q11_BinaryTreeInOrderTraversal q11 = new Q11_BinaryTreeInOrderTraversal();
        ArrayList<Integer> solution = q11.inorderTraversalMy(root);
        for (Integer integer : solution) {
            System.out.println(integer);
        }
    }

    public ArrayList<Integer> inorderTraversalMy(BinaryTreeNode<Integer> root) {
        ArrayList<Integer> solution = new ArrayList<>();
        BinaryTreeNode<Integer> runner = root;
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        while (!stack.isEmpty() || runner != null) {
            while (runner != null) {
                stack.push(runner);
                runner = runner.Left;
            }
            if (!stack.isEmpty()) {
                runner = stack.pop();
                solution.add(runner.Data);
            }
            if (runner != null) {
                runner = runner.Right;
            }
        }
        return solution;
    }
}
