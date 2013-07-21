/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Princeton.Graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author szhao
 */
public class Graph {

    private GraphType Type;
    private int V;
    private int E;
    private ArrayList<Integer>[] adj;
    private ArrayList<Edge>[] adjw;

    public Graph(int v, GraphType type) {
        this.E = 0;
        this.V = v;
        this.Type = type;
        if (type.equals(Type.Weighted)) {
            this.adjw = new ArrayList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new ArrayList<>();
            }
        } else {
            this.adj = new ArrayList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new ArrayList<>();
            }
        }
    }

    public Graph reverse() {
        Graph g_r = new Graph(this.V, this.Type);
        for (int i = 0; i < adj.length; i++) {
            ArrayList<Integer> list = adj[i];
            for (Integer w : list) {
                g_r.addEdge(w, i);
            }
        }
        return g_r;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Graph addEdge(int v, int w) {
        ++E;
        if (Type == GraphType.Directed) {
            adj[v].add(w);
        } else if (Type == GraphType.Undirected) {
            adj[v].add(w);
            adj[w].add(v);
        }
        return this;
    }

    public Graph addEdge(int v, int w, double weight) {
        ++E;
        if (Type == GraphType.Weighted) {
            adjw[v].add(new Edge(v, w, weight));
            adjw[w].add(new Edge(w, v, weight));
        }
        return this;
    }

    public ArrayList<Integer> adj(int v) {
        return adj[v];
    }

    public Iterator<Integer> getReverseEdgeIterator(int v) {
        if (Type == GraphType.Undirected) {
            throw new UnsupportedOperationException();
        }
        return new ReverseEdgeIterator(v);
    }

    private class ReverseEdgeIterator implements Iterable<Integer>, Iterator<Integer> {

        public ReverseEdgeIterator(int v) {
            this.currentV = v;
        }
        int currentV = 0, loopV = 0;

        @Override
        public Iterator<Integer> iterator() {
            return this;
        }

        @Override
        public boolean hasNext() {
            while (loopV < V) {
                if (adj[loopV].contains(currentV)) {
                    return true;
                }
                loopV++;
            }
            return false;
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                return loopV++;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5, GraphType.Directed);
        g.addEdge(0, 1).addEdge(0, 2).addEdge(0, 3).addEdge(0, 4).addEdge(2, 1);
        Iterator<Integer> it = g.getReverseEdgeIterator(1);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
