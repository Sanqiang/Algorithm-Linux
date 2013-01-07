/**
 * Sanqiang Zhao Www.131X.Com Jan 4, 2013
 */
package CareerCup.StacksAndQueues;

import java.util.Stack;

public class Q3_5_QueueOn2Stack {

    public class Queue<T>
    {
        Stack<T> left,right;
        
        public Queue()
        {
            left = new Stack<>();
            right = new Stack<>();
        }
        
        public void enqueue(T val)
        {
            left.push(val);
        }
        
        public T dequeue()
        {
            if (right.isEmpty()) {
                if (left.isEmpty()) {
                    System.out.println("No Data!!!");
                    return null;
                }else{
                    while (!left.isEmpty()) {                        
                        right.push(left.pop());
                    }
                }
            }
            return right.pop();
        }
    }
    
    public static void main(String[] args) {
        
    }
}
