/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Princeton.Graphs.Undirected;

import Princeton.Graphs.Graph;
import Princeton.Graphs.GraphType;
import java.sql.PreparedStatement;
import java.util.Iterator;
import javax.naming.BinaryRefAddr;

/**
 *
 * @author szhao
 */
public class Biconnected {

    int[] pre, id;
    int count;

    public Biconnected(Graph g) {
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
        int children = 0;
        id[v] = count++;
        pre[v] = id[v];
        for (int w : g.adj(v)) {
            if (pre[w] == -1) {
                ++children;
                dfs(g, w, v);
                pre[v] = Math.min(pre[v], pre[w]);
                if (pre[w] >= id[v] && u != v) {
                    System.out.println(v);
                }
            } else if (w != u) {
                pre[v] = Math.min(pre[v], id[w]);
            }
        }
        
        if (u == v && children > 0) {
            System.out.println(u);
        }
        
    }

    public static void main(String[] args) {
        Graph g = new Graph(4, GraphType.Undirected);
        g.addEdge(0, 1).addEdge(1, 2).addEdge(0, 2).addEdge(0, 3);
        Biconnected bc = new Biconnected(g);
    }
}
