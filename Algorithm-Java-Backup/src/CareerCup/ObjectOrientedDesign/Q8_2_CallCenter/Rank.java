/**
 * Sanqiang Zhao Www.131X.Com Dec 28, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_2_CallCenter;

public enum Rank {

    Responder(0),
    Manager(1),
    Director(2);
    private int val;

    private Rank(int _val) {
        this.val = _val;
    }

    public int getValue() {
        return val;
    }
}
