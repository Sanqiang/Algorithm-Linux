/**
 * Sanqiang Zhao Www.131X.Com Dec 24, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_8_ChatServer;

public class Request {

    public User from;
    public User to;
    public RequestStatusType status;

    public Request(User _from, User _to) {
        this.from = _from;
        this.to = _to;
        status = RequestStatusType.Unread;
    }

    public static void main(String[] args) {
    }

}
