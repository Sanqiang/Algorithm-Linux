/**
 * Sanqiang Zhao Www.131X.Com Jan 3, 2013
 */
package CareerCup.StacksAndQueues;

public class Q3_1_ThreeStacks {

    final int NUM_BUFFER = 5;
    final int NUM_STACK = 3;

    public class Stack {

        int[] buffer = new int[NUM_BUFFER];
        StackData[] stack_data = new StackData[NUM_STACK];

        public Stack() {
            for (int i = 0; i < NUM_STACK; i++) {
                stack_data[i] = new StackData(NUM_BUFFER / NUM_STACK * i, NUM_BUFFER / 3);
            }
        }

        public int getTotalCapacity() {
            int capacity = 0;
            for (int i = 0; i < NUM_STACK; i++) {
                capacity += stack_data[i]._capacity;
            }
            return capacity;
        }

        public boolean push(int val, int target) {
            StackData sd = stack_data[target];
            if (sd._pointer == sd._size - 1) {
                expand(target);
            } else if (getTotalCapacity() == NUM_BUFFER) {
                System.out.println("Overflow");
                return false;
            }
            buffer[next(sd._pointer)] = val;
            sd._pointer = next(sd._pointer);
            ++sd._size;
            return true;
        }

        void expand(int target) {
            StackData sd = stack_data[target];
            shift((target + 1) % NUM_STACK);
            ++sd._capacity;
        }

        void shift(int target) {
            StackData sd = stack_data[target];
            if (sd._capacity == sd._size) {
                shift((target + 1) % NUM_STACK);
                for (int i = (sd._start + sd._capacity - 1) % NUM_BUFFER; sd.isInStackData(i, NUM_BUFFER); i = last(i)) {
                    buffer[i] = buffer[last(i)];
                }
                sd._start = next(sd._start);
                sd._pointer = next(sd._pointer);
            } else {
                for (int i = (sd._start + sd._capacity - 1) % NUM_BUFFER; sd.isInStackData(i, NUM_BUFFER); i = last(i)) {
                    buffer[i] = buffer[last(i)];
                }
                sd._start = next(sd._start);
                sd._pointer = next(sd._pointer);
                --sd._capacity;
            }
        }

        public int pop(int target) {
            StackData sd = stack_data[target];
            if (sd._pointer < 0) {
                System.out.println("No Data");
                return Integer.MIN_VALUE;
            }
            int val = buffer[sd._pointer];
            buffer[sd._pointer] = -1;
            --sd._capacity;
            sd._pointer = last(sd._pointer);
            return val;
        }

        public int peek(int target) {
            StackData sd = stack_data[target];
            if (sd._pointer < 0) {
                System.out.println("No Data");
                return Integer.MIN_VALUE;
            }
            int val = buffer[sd._pointer];
            return val;
        }

        int next(int i) {
            if (i == NUM_BUFFER - 1) {
                return 0;
            } else {
                return i + 1;
            }
        }

        int last(int i) {
            if (i == 0) {
                return NUM_BUFFER - 1;
            } else {
                return i - 1;
            }
        }

        void print() {
            for (int i = 0; i < NUM_STACK; i++) {
                StackData sd = stack_data[i];
                System.out.print("T: " + i + " ");
                for (int j = 0; j < sd._capacity; j++) {
                    System.out.print(buffer[sd._pointer + j]);
                }
                System.out.println();
            }
        }

        void printbuffer() {
            for (int i = 0; i < NUM_BUFFER; i++) {
                System.out.print(buffer[i]);
            }
        }
    }

    class StackData {

        int _pointer;
        int _start;
        int _capacity; //volumn
        int _size; //used

        public StackData(int start, int size) {
            this._start = start;
            this._size = size;
            this._pointer = start - 1;
            this._capacity = 0;
        }

        public boolean isInStackData(int i, int total) {
            if (_start + _capacity < total) {
                return i >= _start && i < _start + _capacity;
            } else {
                return (i >= _start && i < total) || (i < _start && i < (_size + _capacity) && i >= 0);
            }
        }
    }

    public static void main(String[] args) {
        Q3_1_ThreeStacks q31 = new Q3_1_ThreeStacks();
        Q3_1_ThreeStacks.Stack stack = q31.new Stack();
        stack.push(9, 0);
        stack.push(8, 0);
        stack.push(7, 0);
        stack.push(6, 0);
        stack.push(5, 0);
        System.out.println(stack.pop(0));
        System.out.println(stack.pop(0));
        System.out.println(stack.pop(0));
        System.out.println(stack.pop(0));
        stack.push(11, 1);
        stack.push(22, 2);
        System.out.println(stack.pop(2));
        System.out.println(stack.pop(1));
    }
}
