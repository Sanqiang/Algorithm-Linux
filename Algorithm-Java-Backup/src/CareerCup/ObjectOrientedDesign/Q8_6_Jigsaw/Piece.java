/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_6_Jigsaw;

public class Piece {

    Edge[] edges;

    public PieceType getPieceType() {
        int flat_count = 0;
        for (int i = 0; i < 4; i++) {
            if (edges[i].type == EdgeType.flat) {
                ++flat_count;
            }
        }
        if (flat_count == 2) {
            return PieceType.corner;
        } else if (flat_count == 1) {
            return PieceType.border;
        } else {
            return PieceType.inner;
        }
    }

    public static void main(String[] args) {
    }
}
