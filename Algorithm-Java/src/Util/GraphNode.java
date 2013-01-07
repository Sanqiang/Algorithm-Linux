/**
 * Sanqiang Zhao Www.131X.Com Jan 4, 2013
 */
package Util;

import java.util.ArrayList;

public class GraphNode<V> {
    
    public V Data;
    public ArrayList<GraphNode<V>> Nodes;
    public short state;
    
    public GraphNode(V _data) {
        this.Data = _data;
        this.Nodes = new ArrayList<>();
    }
    
    public void add(V val) {
        GraphNode<V> node = new GraphNode<>(val);
        add(node);
    }
    
    public void add(GraphNode node) {
        Nodes.add(node);
    }
    
    public static GraphNode<Integer> getSampleGraphNode()
    {
        GraphNode<Integer> n1 = new GraphNode<>(1);
        n1.add(2);
        n1.add(3);
        n1.Nodes.get(0).add(n1);
        return n1;
    }
    
        public static GraphNode<Integer> getSampleGraphNode2()
    {
        GraphNode<Integer> n1 = new GraphNode<>(1);
        n1.add(2);
        n1.add(3);
        return n1;
    }
    
    public static void main(String[] args) {
    }
}
