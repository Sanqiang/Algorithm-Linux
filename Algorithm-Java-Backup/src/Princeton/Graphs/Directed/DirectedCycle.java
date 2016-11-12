/**
 * Sanqiang Zhao Www.131X.Com Jul 4, 2013
 */
package Princeton.Graphs.Directed;

import Princeton.Graphs.Graph;
import Princeton.Graphs.GraphType;
import java.util.Stack;

public class DirectedCycle {

    int[] pathTo;
    boolean[] marked;
    boolean[] onStacked;

    public DirectedCycle(Graph g) {
        marked = new boolean[g.V()];
        onStacked = new boolean[g.V()];
        pathTo = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            if (!marked[i]) {
                dfs(g, i);
            }
        }
    }

    public void dfs(Graph g, int v) {
        marked[v] = true;
        onStacked[v] = true;
        for (int adj : g.adj(v)) {
            if (!marked[adj]) {
                pathTo[v] = adj;
                dfs(g, adj);
            } else if (onStacked[adj]) {
                Stack<Integer> s = new Stack<>();
                int loop = adj;
                s.push(adj);
                loop = pathTo[loop];
                while (loop != adj) {
                    s.push(loop);
                    loop = pathTo[loop];
                }
                for (Integer step : s) {
                    System.out.println(step);
                }
                return;
            }
        }
        onStacked[v] = false;
    }

    public static void main(String[] args) {
        Graph g = new Graph(3, GraphType.Directed);
        g.addEdge(0, 1).addEdge(1, 2).addEdge(2, 0);
        DirectedCycle dc = new DirectedCycle(g);
    }
}
