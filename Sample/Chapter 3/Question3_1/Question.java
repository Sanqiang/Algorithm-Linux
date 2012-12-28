package Question3_1;

public class Question {
	static int stackSize = 10;
	static int [] buffer = new int [stackSize * 3];
	
	// 3 stack pointers to keep track of the index of the top element
	static int [] stackPointer = {0, 0, 0};
	public static void main(String [] args) throws Exception  {
		push(2, 4);
		System.out.println(peek(2));
		push(0, 3);
		push(0, 7);
		push(0, 5);
		System.out.println(peek(0));
		pop(1);
		System.out.println(peek(0));
		pop(0);
	}

	static void push(int stackNum, int value) throws Exception {
		/* Check that we have space */
		if (stackPointer[stackNum] >= stackSize) {
			throw new Exception("Out of space.");
		}
		/* Find the index of the top element in the array + 1, 
		 * and increment the stack pointer */		
		int index = stackNum * stackSize + stackPointer[stackNum] + 1;
		stackPointer[stackNum]++;
		buffer[index] = value;	
	}

	static int pop(int stackNum) throws Exception {
		if (stackPointer[stackNum] == 0) {
			throw new Exception("Trying to pop an empty stack.");
		}
		int index = stackNum * stackSize + stackPointer[stackNum];
		stackPointer[stackNum]--;
		int value = buffer[index];
		buffer[index] = 0;
		return value;
	}

	static int peek(int stackNum) {
		int index = stackNum * stackSize + stackPointer[stackNum];
		return buffer[index];
	}

	static boolean isEmpty(int stackNum) {
		return stackPointer[stackNum] == 0;
	}
}
