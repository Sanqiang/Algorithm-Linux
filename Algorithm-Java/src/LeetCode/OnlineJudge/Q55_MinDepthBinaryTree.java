/**
 * Sanqiang Zhao Www.131X.Com Dec 22, 2012
 */
package LeetCode.OnlineJudge;

import Util.BinaryTreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class Q55_MinDepthBinaryTree {

    public int minDepthRC(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int l = minDepthRC(root.Left);
        int r = minDepthRC(root.Right);
        int result = 1 + Math.min(l, r);
        return result;
    }

    public int minDepth(BinaryTreeNode<Integer> root) {
        Queue<Wrapper> q = new LinkedList<>();
        q.add(new Wrapper(root, 1));
        while (!q.isEmpty()) {
            Wrapper wr = q.poll();
            BinaryTreeNode<Integer> node = wr.node;
            int level = wr.level;
            if (node.Left == null && node.Right == null) {
                return level;
            }
            if (node.Left != null) {
                q.add(new Wrapper(node.Left, level + 1));
            }
            if (node.Right != null) {
                q.add(new Wrapper(node.Right, level + 1));
            }
        }
        return -1;
    }

    class Wrapper {

        BinaryTreeNode<Integer> node;
        int level;

        public Wrapper(BinaryTreeNode<Integer> _node, int _level) {
            this.node = _node;
            this.level = _level;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.getSampleTree();
        int level = new Q55_MinDepthBinaryTree().minDepth(root);
        System.out.println(level);
        int level2 = new Q55_MinDepthBinaryTree().minDepthRC(root);
        System.out.println(level2);
    }
}
