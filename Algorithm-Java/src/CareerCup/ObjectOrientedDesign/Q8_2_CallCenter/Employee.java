/**
 * Sanqiang Zhao Www.131X.Com Dec 28, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_2_CallCenter;

public abstract class Employee {

    public Call current_call;
    Rank rank;

    public void receiveCall(Call c) {
        current_call = c;
    }

    public boolean isFree() {
        return current_call == null;
    }

    public void callComplete() {
        if (current_call != null) {
            current_call.disconnect();
            current_call = null;
        }
        assignNewCall();
    }

    public void assignNewCall() {
        if (isFree()) {
            CallHandler.getInstance().assignCall(this);
        }
    }

    public void escalateCall() {
        if (current_call != null) {
            current_call.incrementRank();
            CallHandler.getInstance().dispatchCall(current_call);
            current_call = null;
        }
        assignNewCall();
    }

    public static void main(String[] args) {
    }
}
