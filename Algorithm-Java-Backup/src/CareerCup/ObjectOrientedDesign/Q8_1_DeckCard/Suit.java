/**
 * Sanqiang Zhao Www.131X.Com Dec 28, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_1_DeckCard;

public enum Suit {

    Club(0),
    Diamond(1),
    Heart(2),
    Spade(3);
    int i;

    Suit(int _i) {
        this.i = _i;
    }

    public int getValue() {
        return i;
    }

    public static Suit getSuitFromValue(int value) {
        switch (value) {
            case 0:
                return Suit.Club;
            case 1:
                return Suit.Diamond;
            case 2:
                return Suit.Heart;
            case 3:
                return Suit.Spade;
            default:
                return null;
        }
    }
}
