/**
 * Sanqiang Zhao Www.131X.Com Jan 4, 2013
 */
package CareerCup.TreesAndGraphs;

import Util.BinaryTreeNode;

public class Q4_6_NextNode {

    public BinaryTreeNode<Integer> next(BinaryTreeNode<Integer> node) {
        BinaryTreeNode<Integer> runner = node;
        if (runner.Right != null) {
            runner = runner.Right;
            while (runner.Left != null) {
                runner = runner.Left;
            }
            return runner;
        }else{
            BinaryTreeNode<Integer> parent = runner.Parent;
            while (parent.Left == runner) {                
                runner = parent;
                parent = runner.Parent;
            }
            return parent;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> node = BinaryTreeNode.getSampleTree();
        Q4_6_NextNode q46 = new Q4_6_NextNode();
        System.out.println(q46.next(node).Data);
    }
}
