/**
 * Sanqiang Zhao Www.131X.Com Dec 24, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_8_ChatServer;

import java.math.BigInteger;

public class GroupChat extends Conversation {
    
    public GroupChat(BigInteger _id, User _creater) {
        super(_id);
        participants.add(_creater);
    }
    
    public void addParticipant(User _participant) {
        participants.add(_participant);
    }
    
    public static void main(String[] args) {
    }
}
