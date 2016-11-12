/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_5_OnlineBookReader;

public class Display {

    private Book active_book;
    private User active_user;
    private long page_num;

    public Display(Book _book, User _user) {
        this.active_book = _book;
        this.active_user = _user;
        page_num = 1;
    }

    public static void main(String[] args) {
    }
}
