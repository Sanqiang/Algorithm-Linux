/**
 * Sanqiang Zhao Www.131X.Com Dec 28, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_2_CallCenter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CallHandler {

    final int NUM_LEVEL = 3;
    final int NUM_RESPONDENT = 10;
    final int NUM_MANAGER = 5;
    final int NUM_DIRECTOR = 1;
    private static CallHandler inst;
    ArrayList<Employee> employees[];
    Queue<Call> callqueue[];

    private CallHandler() {
        int i;
        employees = new ArrayList[NUM_LEVEL];
        for (i = 0; i < NUM_LEVEL; i++) {
            employees[i] = new ArrayList<>();
        }
        callqueue = new LinkedList[NUM_LEVEL];
        for (i = 0; i < NUM_LEVEL; i++) {
            callqueue[i] = new LinkedList<>();
        }
        for (i = 0; i < NUM_RESPONDENT; i++) {
            employees[0].add(new Respondent());
        }
        for (i = 0; i < NUM_MANAGER; i++) {
            employees[1].add(new Manager());
        }
        for (i = 0; i < NUM_DIRECTOR; i++) {
            employees[2].add(new Director());
        }
    }

    public static CallHandler getInstance() {
        if (inst == null) {
            inst = new CallHandler();
        }
        return inst;
    }

    public Employee getHandlerForCall(Call c) {
        for (Rank i = c.rank; i != null; c.incrementRank()) {
            ArrayList<Employee> list = employees[i.getValue()];
            for (Employee employee : list) {
                if (employee.isFree()) {
                    //employee.receiveCall(c);
                    return employee;
                }
            }
        }
        return null;
    }

    public void dispatchCall(Call c) {
        Employee employee = getHandlerForCall(c);
        if (employee != null) {
            employee.receiveCall(c);
            c.handler = employee;
        } else {
            System.out.println("No Available employee");
            callqueue[c.rank.getValue()].add(c);
        }
    }

    public boolean assignCall(Employee e) {
        for (int r = e.rank.getValue(); r >= 0; --r) {
            Queue<Call> queue = callqueue[r];
            if (queue.peek() != null) {
                e.receiveCall(queue.poll());
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
    }
}
