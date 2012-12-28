package Question8_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* CallHandler is implement as a singleton class. It represents the body of the program,
 * and all calls are funneled first through it. 
 */
public class CallHandler {
	private static CallHandler instance;
	
	/* We have 3 levels of employees: respondents, managers, directors. */
    private final int LEVELS = 3; 
    
    /* Initialize with 10 respondents, 4 managers, and 2 directors. */
    private final int NUM_RESPONDENTS = 10;
    private final int NUM_MANAGERS = 4;
    private final int NUM_DIRECTORS = 2;

    /* List of employees, by level.
     * employeeLevels[0] = respondents
     * employeeLevels[1] = managers
     * employeeLevels[2] = directors
     */
    ArrayList<Employee>[] employeeLevels;

	/* queues for each call’s rank */
    Queue<Call>[] callQueues; 

    public CallHandler() {
    	employeeLevels = new ArrayList[LEVELS];
    	callQueues = new LinkedList[LEVELS]; 
    	
        // Create respondents.
        ArrayList<Employee> respondents = new ArrayList<Employee>(NUM_RESPONDENTS);
        for (int k = 0; k < NUM_RESPONDENTS - 1; k++) {
            respondents.add(new Respondent());
        }
        employeeLevels[0] = respondents;

        // Create managers.
        ArrayList<Employee> managers = new ArrayList<Employee>(NUM_MANAGERS);
        managers.add(new Manager());
        employeeLevels[1] = managers;

        // Create directors.
        ArrayList<Employee> directors = new ArrayList<Employee>(NUM_DIRECTORS);
        directors.add(new Director());
        employeeLevels[2] = directors;
    }
    
    /* Get instance of singleton class. */
    public static CallHandler getInstance() {
    	if (instance == null) {
    		instance = new CallHandler();
    	}
    	return instance;
    }
    
    /* Gets the first available employee who can handle this call. */
    public Employee getHandlerForCall(Call call) {
        for (int level = call.getRank().getValue(); level < LEVELS - 1; level++) {
            ArrayList<Employee> employeeLevel = employeeLevels[level];
            for (Employee emp : employeeLevel) {
                if (emp.isFree()) {
                    return emp;
                }
            }
        }
        return null;
    }

    /* Routes the call to an available employee, or saves in a queue if no employee available. */
    public void dispatchCall(Caller caller) {
    	Call call = new Call(caller);
    	dispatchCall(call);
    }
    
    /* Routes the call to an available employee, or saves in a queue if no employee available. */
    public void dispatchCall(Call call) {
    	/* Try to route the call to an employee with minimal rank. */
        Employee emp = getHandlerForCall(call);
        if (emp != null) {
        	emp.receiveCall(call);
        	call.setHandler(emp);
        } else {
	        /* Place the call into corresponding call queue according to its rank. */
	        call.reply("Please wait for free employee to reply");
	        callQueues[call.getRank().getValue()].add(call);
        }
    }    

    /* An employee got free. Look for a waiting call that he/she can serve. Return true
     * if we were able to assign a call, false otherwise. */
    public boolean assignCall(Employee emp) {
        /* Check the queues, starting from the highest rank this employee can serve. */
        for (int rank = emp.getRank().getValue(); rank >= 0; rank--) {
            Queue<Call> que = callQueues[rank];
            
            /* Remove the first call, if any */
            Call call = que.poll(); 
            if (call != null) {
                emp.receiveCall(call);
                return true;
            }
        }
        return false;
    }
}


