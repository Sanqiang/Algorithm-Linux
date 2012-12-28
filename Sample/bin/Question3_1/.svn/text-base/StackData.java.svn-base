package Question3_1;

public class StackData {
	public int start;
	public int pointer;
	public int size = 0;
	public int capacity;
	public StackData(int _start, int _capacity) {
		start = _start;
		pointer = _start - 1;
		capacity = _capacity;
	}
	
	public boolean isWithinStack(int index, int total_size) {
		if (start + capacity <= total_size) { // normal case
			if (start <= index && index <= start + capacity) {
				return true;
			} else {
				return false;
			}
		} else {
			int shifted_index = index + total_size;
			if (start <= shifted_index && shifted_index <= start + capacity) {
				return true;
			} else {
				return false;
			}			
		}
	}
}
