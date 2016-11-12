/**
 * Sanqiang Zhao Www.131X.Com Jan 4, 2013
 */
package CareerCup.TreesAndGraphs;

import LeetCode.OnlineJudge.Q42_LetterCombinationPhoneNum;
import Util.GraphNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q4_2_BFSOnGraph {

    public boolean isConnect(GraphNode<Integer> root) {
        Queue<GraphNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            GraphNode<Integer> cur = q.poll();
            cur.state = 1;
            ArrayList<GraphNode<Integer>> nodes = cur.Nodes;
            for (GraphNode<Integer> node : nodes) {
                if (node.state == 1) {
                    System.out.println(node.Data);
                    return false;
                } else if (node.state == 0) {
                    q.add(node);
                } else {
                    System.out.println("ERROR");
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        GraphNode<Integer> root1 = GraphNode.getSampleGraphNode();
        GraphNode<Integer> root2 = GraphNode.getSampleGraphNode2();
        Q4_2_BFSOnGraph q42 = new Q4_2_BFSOnGraph();
        q42.isConnect(root1);
        q42.isConnect(root2);
    }
}
