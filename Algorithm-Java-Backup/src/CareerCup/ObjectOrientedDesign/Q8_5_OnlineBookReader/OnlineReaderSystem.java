/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_5_OnlineBookReader;

import java.util.HashSet;

public class OnlineReaderSystem {

    private Library lib;
    private UserManager manager;
    private HashSet<Display> displays;
    private static OnlineReaderSystem inst;

    private OnlineReaderSystem() {
        lib = Library.getInstance();
        manager = UserManager.getInstance();
        displays = new HashSet<>();
    }

    public Display read(User _user, Book _book) {
        Display d = new Display(_book, _user);
        if (!displays.contains(d)) {
            displays.add(d);
        }
        return d;
    }

    public static void main(String[] args) {
    }
}
