/**
 * Sanqiang Zhao Www.131X.Com Dec 24, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_8_ChatServer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class User {

    private UserStatus status;
    private BigInteger id;
    private String nickname;
    private String account;
    public ArrayList<BigInteger> contacts;
    public ArrayList<Request> send_list;
    public ArrayList<Request> receive_list;
    public ArrayList<GroupChat> groupchats;
    public ArrayList<PrivateChat> privatechats;

    public User(BigInteger _id, String _nickname, String _account) {
        this.id = _id;
        this.nickname = _nickname;
        this.account = _account;
        status = new UserStatus();
        contacts = new ArrayList<>();
        send_list = new ArrayList<>();
        receive_list = new ArrayList<>();
        groupchats = new ArrayList<>();
        privatechats = new ArrayList<>();
    }

    public BigInteger getId() {
        return id;
    }

    public void Speak(String msg, Conversation s) {
        Date now = new Date();
        Message m = new Message(msg, now, this);
        if (s instanceof PrivateChat) {
            if (s.participants.contains(this) && privatechats.contains(s)) {
                s.messages.add(m);
            }
        } else if (s instanceof GroupChat) {
            if (groupchats.contains(s)) {
                s.messages.add(m);
            }
        }
    }

    public void addConversation(Conversation c) {
        if (c instanceof GroupChat) {
            groupchats.add((GroupChat) c);
        } else if (c instanceof PrivateChat) {
            privatechats.add((PrivateChat) c);
        }
    }

    public void sendRequest(User _to) {
        UserManager.getInstance().sendRequest(this, _to);
    }

    public void approveRequest(User _to) {
        UserManager.getInstance().approveRequest(this, _to);
    }

    public void declineRequest(User _to) {
        UserManager.getInstance().declineRequest(this, _to);
    }

    public static void main(String[] args) {
        User u = new User(BigInteger.ONE, "Sanqiang", "zsq@131x.com");
        Conversation c = new GroupChat(BigInteger.ONE, u);
        u.addConversation(c);
        if (u.groupchats.contains(c)) {
            System.out.println("Ok");
        }
    }
}
