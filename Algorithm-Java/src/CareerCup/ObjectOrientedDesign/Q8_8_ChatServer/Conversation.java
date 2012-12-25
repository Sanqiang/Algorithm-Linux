/**
 * Sanqiang Zhao Www.131X.Com Dec 24, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_8_ChatServer;

import java.math.BigInteger;
import java.util.ArrayList;

public abstract class Conversation {

    ArrayList<Message> messages;
    ArrayList<User> participants;
    BigInteger id;

    public Conversation(BigInteger _id) {
        this.id = _id;
        messages = new ArrayList<>();
        participants = new ArrayList<>();
    }

    public static void main(String[] args) {
    }
}
