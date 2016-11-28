package Lintcode.Base.L2;

public class RotateString {
	/**
	 * @param str:
	 *            an array of char
	 * @param offset:
	 *            an integer
	 * @return: nothing
	 */
	public void rotateString(char[] str, int offset) {
		if (str == null || str.length == 0) {
			return;
		}
		offset = offset % str.length;
		reverse(str, 0, str.length - 1 - offset);
		reverse(str, str.length - offset, str.length - 1);
		reverse(str, 0, str.length - 1);
	}

	void reverse(char[] str, int left, int right) {
		while (left < right) {
			char temp = str[left];
			str[left] = str[right];
			str[right] = temp;
			++left;
			--right;
		}
	}
}
