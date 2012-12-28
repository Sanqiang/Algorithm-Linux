/**
 * Sanqiang Zhao Www.131X.Com Dec 28, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_1_DeckCard;

import java.util.ArrayList;

public class Hand<T extends Card> {
    
    public ArrayList<T> cards_onhand;
    
    public Hand() {
        cards_onhand = new ArrayList<>();
    }
    
    public int value() {
        int val = 0;
        for (T t : cards_onhand) {
            val += t.value();
        }
        return val;
    }
    
    public void add(T card) {
        cards_onhand.add(card);
    }
    
    public static void main(String[] args) {
    }
}
