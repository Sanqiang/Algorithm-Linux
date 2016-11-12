/**
 * Sanqiang Zhao Www.131X.Com Dec 17, 2012
 */
package LeetCode.OnlineJudge;

import Util.BinaryTreeNode;

public class Q14_MaximumPathSum {

    public int maxPathSum(BinaryTreeNode<Integer> root) {
        return maxPathSumHelper(root).RouteVal;
    }

    private Wrapper maxPathSumHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new Wrapper(0, 0);
        }
        Wrapper l = maxPathSumHelper(root.Left);
        Wrapper r = maxPathSumHelper(root.Right);
        int depthval = Math.max(l.DepthVal, r.DepthVal) + root.Data;
        int routeval = l.DepthVal + r.DepthVal + root.Data;
        Wrapper wr = new Wrapper(depthval, routeval);
        return wr;
    }

    class Wrapper {

        public int DepthVal;
        public int RouteVal;

        public Wrapper(int _depthval, int _routeval) {
            this.DepthVal = _depthval;
            this.RouteVal = _routeval;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.getSampleTree();
        int distance = new Q14_MaximumPathSum().maxPathSum(root);
        System.out.println(distance);
    }
}
