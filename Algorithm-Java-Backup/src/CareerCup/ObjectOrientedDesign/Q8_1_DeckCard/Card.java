/**
 * Sanqiang Zhao Www.131X.Com Dec 28, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_1_DeckCard;

public abstract class Card {

    int face_value;
    Suit suit;
    boolean avaiable;

    public Card(int _val, Suit _suit) {
        this.face_value = _val;
        this.suit = _suit;
        avaiable = true;
    }

    public void markAvailable(boolean isAvailable) {
        this.avaiable = isAvailable;
    }

    public abstract int value();

    public static void main(String[] args) {
    }
}
