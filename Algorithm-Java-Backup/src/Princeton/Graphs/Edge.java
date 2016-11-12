/**
 * Sanqiang Zhao Www.131X.Com Jul 5, 2013
 */
package Princeton.Graphs;

public class Edge implements Comparable<Edge> {

    public int v;
    public int w;
    public double weight;

    public Edge(int v, int w, double  weight)
    {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Edge t) {
        if (this.weight > t.weight) {
            return 1;
        } else if (this.weight < t.weight) {
            return -1;
        } else {
            return 0;
        }
    }
}
