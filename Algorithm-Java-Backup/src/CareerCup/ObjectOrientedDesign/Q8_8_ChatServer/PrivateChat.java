/**
 * Sanqiang Zhao Www.131X.Com Dec 24, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_8_ChatServer;

import java.math.BigInteger;

public class PrivateChat extends Conversation {
    
    public PrivateChat(BigInteger _id, User _from, User _to) {
        super(_id);
        participants.add(_from);
        participants.add(_to);
    }
    
    public static void main(String[] args) {
    }
}
