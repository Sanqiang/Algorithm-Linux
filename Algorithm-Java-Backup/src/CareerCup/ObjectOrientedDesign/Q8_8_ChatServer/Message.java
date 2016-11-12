/**
 * Sanqiang Zhao Www.131X.Com Dec 24, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_8_ChatServer;

import java.util.Date;

public class Message {

    public String message;
    public Date send_time;
    public User sender;

    public Message(String _msg, Date _sendtime, User _poster) {
        this.message = _msg;
        this.send_time = _sendtime;
        this.sender = _poster;
    }

    public static void main(String[] args) {
    }
}
