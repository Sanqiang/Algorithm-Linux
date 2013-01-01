/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.Hard;

public class Q18_2_ShuffleCard {

    public void shuffle(int[] cards) {
        int i, length = cards.length;
        for (i = 0; i < length - 1; i++) {
            int r = (int) (Math.random() * (length - i)) + i;
            int temp = cards[r];
            cards[r] = cards[i];
            cards[i] = temp;
        }
    }

    public static void main(String[] args) {
    }
}
