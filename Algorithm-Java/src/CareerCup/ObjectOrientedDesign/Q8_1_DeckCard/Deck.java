/**
 * Sanqiang Zhao Www.131X.Com Dec 28, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_1_DeckCard;

import java.util.ArrayList;
import java.util.Random;

public class Deck<T extends Card> {

    public ArrayList<T> cards;
    private int dealt_num = 0;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public int remainingCard() {
        return cards.size() - dealt_num;
    }

    public T[] dealtHand(int num) {
        if (num > remainingCard()) {
            return null;
        }
        T[] card_hand = (T[]) new Card[num];
        for (int i = 0; i < num; i++) {
            T card = dealtCard();
            if (card != null) {
                card_hand[i] = card;
            }
        }
        return card_hand;
    }

    public T dealtCard() {
        if (remainingCard() == 0) {
            return null;
        }
        T card = cards.get(dealt_num);
        card.markAvailable(false);
        ++dealt_num;
        return card;
    }

    public void shuffle() {
        Random r = new Random(System.currentTimeMillis());
        int i, size = cards.size(), j;
        for (i = 0; i < size; i++) {
            j = r.nextInt(size);
            T card1 = cards.get(i);
            T card2 = cards.get(j);
            cards.set(i, card2);
            cards.set(j, card1);
        }
    }

    public static void main(String[] args) {
    }
}
