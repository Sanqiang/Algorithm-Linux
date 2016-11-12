/**
 * Sanqiang Zhao Www.131X.Com Dec 28, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_2_CallCenter;

public class Call {

    public Rank rank;
    public Caller caller;
    public Employee handler;

    public Rank incrementRank() {
        if (rank == Rank.Responder) {
            rank = Rank.Manager;
        } else if (rank == Rank.Manager) {
            rank = Rank.Director;
        }
        return null;
    }

    public void disconnect() {
        System.out.println("Good Bye");
    }

    public static void main(String[] args) {
    }
}
