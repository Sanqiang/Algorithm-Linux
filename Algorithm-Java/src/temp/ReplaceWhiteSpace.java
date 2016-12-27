package temp;

public class ReplaceWhiteSpace {
	void replace(char[] input) {
		int loop_idx = 0, append_idx = 0;
		while (loop_idx < input.length) {
			if (loop_idx != append_idx) {
				char temp = input[loop_idx];
				input[loop_idx] = input[append_idx];
				input[append_idx] = temp;
			}

			if (input[append_idx] != ' ') {
				++append_idx;
			}

			++loop_idx;
		}
	}

	public static void main(String[] args) {
		char[] input = new char[] { 'a', 'b', ' ', 'c', 'd', ' ', 'e' };
		for (char c : input) {
			System.out.println(c);
		}
		System.out.println("=====");
		new ReplaceWhiteSpace().replace(input);
		for (char c : input) {
			System.out.println(c);
		}
		System.out.println("=====");
	}
}
