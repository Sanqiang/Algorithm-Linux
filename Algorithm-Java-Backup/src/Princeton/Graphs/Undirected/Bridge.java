/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Princeton.Graphs.Undirected;

import Princeton.Graphs.Graph;
import Princeton.Graphs.GraphType;

/**
 *
 * @author szhao
 */
public class Bridge {

    int[] id, pre;
    int count;

    public Bridge(Graph g) {
        count = 0;
        id = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            id[i] = -1;
        }
        pre = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            pre[i] = -1;
        }
        for (int i = 0; i < g.V(); i++) {
            if (pre[i] == -1) {
                dfs(g, i, i);
            }
        }
    }

    private void dfs(Graph g, int v, int u) {
        id[v] = count++;
        pre[v] = id[v];
        for (int w : g.adj(v)) {
            if (pre[w] == -1) {
                dfs(g, w, v);
                pre[v] = Math.min(pre[v], pre[w]);
                if (pre[w] == id[w]) {
                    System.out.println(v + "-" + w);
                }
            } else if (w != u) {
                pre[v] = Math.min(pre[v], id[w]);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(3, GraphType.Undirected);
        g.addEdge(0, 1).addEdge(1, 2).addEdge(0, 2);
        Bridge b = new Bridge(g);
    }
}
