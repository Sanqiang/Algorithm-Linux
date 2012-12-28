/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_6_Jigsaw;

public class Edge {

    public EdgeType type;
    public Piece parent;
    
    public boolean fitWith(Edge e) {
        if (e.type == EdgeType.flat || this.type == EdgeType.flat) {
            return false;
        } else if (e.type == EdgeType.inner) {
            return this.type == EdgeType.outer;
        } else if (e.type == EdgeType.outer) {
            return this.type == EdgeType.inner;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        
    }
}
