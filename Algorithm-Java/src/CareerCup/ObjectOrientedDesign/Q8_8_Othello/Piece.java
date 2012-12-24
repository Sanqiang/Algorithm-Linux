/**
 * Sanqiang Zhao Www.131X.Com Dec 23, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_8_Othello;

public class Piece {
    
    private Color color;
    
    public void setColor(Color _color) {
        this.color = _color;
    }
    
    public Color getColor() {
        return color;
    }
    
    public Piece(Color _color) {
        this.color = _color;
    }
    
    public void flip() {
        if (this.getColor() == Color.Black) {
            this.setColor(Color.White);
        } else {
            this.setColor(Color.Black);
        }
    }
    
    public static void main(String[] args) {
    }
}
