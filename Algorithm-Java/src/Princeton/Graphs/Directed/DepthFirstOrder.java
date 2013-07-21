/**
 * Sanqiang Zhao Www.131X.Com Jul 4, 2013
 */
package Princeton.Graphs.Directed;

import Princeton.Graphs.Graph;
import Princeton.Graphs.GraphType;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstOrder {

    private boolean[] marked;          // marked[v] = has v been marked in dfs?
    public Queue<Integer> preorder;   // vertices in preorder
    public Queue<Integer> postorder;  // vertices in postorder
    public Queue<Integer> reverseorder;  // vertices in reverse
//    private int[] pre;                 // pre[v]    = preorder  number of v
//    private int[] post;                // post[v]   = postorder number of v
//    private int preCounter;            // counter or preorder numbering
//    private int postCounter;           // counter for postorder numbering

    public DepthFirstOrder(Graph g) {
//        pre = new int[g.V()];
//        post = new int[g.V()];
        postorder = new LinkedList<Integer>();
        preorder = new LinkedList<Integer>();
        reverseorder = new LinkedList<>();
        marked = new boolean[g.V()];
        for (int i = 0; i < g.V(); i++) {
            if (!marked[i]) {
                dfs(g, i);
            }
        }
        reverse();
    }

    public void dfs(Graph g, int v) {
        marked[v] = true;
        preorder.add(v);
        for (Integer adj : g.adj(v)) {
            if (!marked[adj]) {
                dfs(g, adj);
            }
        }
        postorder.add(v);
    }

    public void reverse() {
        Stack<Integer> reverse = new Stack<Integer>();
        for (int v : postorder) {
            reverse.push(v);
        }
        while (!reverse.isEmpty()) {            
            reverseorder.add(reverse.pop());
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6, GraphType.Directed);
        g.addEdge(0, 1).addEdge(2, 3).addEdge(3, 4).addEdge(4, 5).addEdge(0, 2).addEdge(2, 4).addEdge(3, 5).addEdge(2, 1);
        DepthFirstOrder dfo = new DepthFirstOrder(g);
        for (Integer i : dfo.preorder) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (Integer i : dfo.postorder) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (Integer i : dfo.reverseorder) {
            System.out.print(i + " ");
        }
    }
}
