package Question17_6;

public class Question {

	public static int findEndOfLeftSubsequence(int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				return i - 1;
			}
		}
		return array.length - 1;
	}
	
	public static int findStartOfRightSubsequence(int[] array) {
		for (int i = array.length - 2; i >= 0; i--) {
			if (array[i] > array[i + 1]) {
				return i + 1;
			}
		}
		return 0;
	}		
	
	public static int shrinkLeft(int[] array, int min_index, int start) {
		int comp = array[min_index];
		for (int i = start - 2; i >= 0; i--) {
			if (array[i] <= comp) {
				return i + 1;
			}
		}
		return 0;
	}
	
	public static int shrinkRight(int[] array, int max_index, int start) {
		int comp = array[max_index];
		for (int i = start; i < array.length; i++) {
			if (array[i] >= comp) {
				return i - 1;
			}
		}
		return array.length - 1;
	}	
	
	public static void findUnsortedSequence(int[] array) {
		// find left subsequence
		int end_left = findEndOfLeftSubsequence(array);
		
		// find right subsequence
		int start_right = findStartOfRightSubsequence(array);		
		
		// find min and max element of middle
		int min_index = end_left + 1;
		int max_index = start_right - 1;
		for (int i = end_left; i <= start_right; i++) {
			if (array[i] < array[min_index]) {
				min_index = i;
			}
			if (array[i] > array[max_index]) {
				max_index = i;
			}
		}		
		
		// slide left until less than array[min_index]
		int left_index = shrinkLeft(array, min_index, end_left);

		// slide right until greater than array[max_index]
		int right_index = shrinkRight(array, max_index, start_right);
		
		System.out.println(left_index + " " + right_index);
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 4, 7, 10, 11, 7, 12, 8, 11, 16, 18, 19};
		findUnsortedSequence(array);
	}

}
