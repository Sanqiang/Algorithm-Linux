/**
 * Sanqiang Zhao Www.131X.Com Jul 5, 2013
 */
package Princeton.Graphs.Directed;

import Princeton.Graphs.Graph;
import Princeton.Graphs.GraphType;

public class KosarajuSharirSCC {

    private boolean[] marked;     // marked[v] = has vertex v been visited?
    private int[] id;             // id[v] = id of strong component containing v
    private int count;            // number of strongly-connected components

    public KosarajuSharirSCC(Graph g) {
        DepthFirstOrder dfo = new DepthFirstOrder(g.reverse());
        marked = new boolean[g.V()];
        id = new int[g.V()];
        for (int v : dfo.reverseorder) {
            if (!marked[v]) {
                dfs(g, v);
                count++;
            }
        }
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4, GraphType.Directed);
        g.addEdge(0,1).addEdge(1, 2).addEdge(2, 3).addEdge(3, 0);
        KosarajuSharirSCC ks = new KosarajuSharirSCC(g);
        System.out.println(ks.count);
    }
}
