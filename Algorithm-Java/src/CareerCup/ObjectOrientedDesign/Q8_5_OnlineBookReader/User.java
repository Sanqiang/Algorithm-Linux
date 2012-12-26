/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_5_OnlineBookReader;

import java.math.BigInteger;

public class User {

    private BigInteger ID;
    public String Name;
    private short Type;

    public User(BigInteger _id, String _name, short _type) {
        this.ID = _id;
        this.Name = _name;
        this.Type = _type;
    }

    public static void main(String[] args) {
    }
}
