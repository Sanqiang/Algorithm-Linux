import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	static String processE(String line) {
		StringBuilder temp = new StringBuilder();
		boolean process_flag = false;
		for (int i = line.length() - 1; i >= 3; i--) {
			char ch = line.charAt(i);
			if (process_flag) {
				temp.insert(0, ch);
				break;
			} else {
				temp.insert(0, ch);
			}
			if (ch == '@') {
				process_flag = true;
			}
		}
		for (int i = 0; i < 5; i++) {
			temp.insert(0, "*");
		}
		temp.insert(0, line.charAt(2));
		temp.insert(0, "E:");
		return temp.toString();
	}

	static String processP(String line) {
		StringBuilder temp = new StringBuilder();
		int i = line.length() - 1;
		for (; i >= line.length() - 4; i--) {
			char ch = line.charAt(i);
			temp.insert(0, ch);
		}
		int cnt = 6;
		temp.insert(0, "***-***-");
		for (; i >= 2; i--) {
			char ch = line.charAt(i);
			if (ch >= '0' && ch <= '9') {
				--cnt;
				if (cnt == 0) {
					--i;
					break;
				}
			}
		}
		boolean process_flag = true;
		for (; i >= 2; i--) {
			char ch = line.charAt(i);
			if (ch >= '0' && ch <= '9') {
				temp.insert(0, "*");
				process_flag = true;
			} else if (ch == '+') {
				temp.insert(0, ch);
				process_flag = true;
			} else {
				if (process_flag) {
					temp.insert(0, "-");
					process_flag = false;
				}
			}
		}
		if (temp.toString().startsWith("-")) {
			temp.deleteCharAt(0);
		}
		temp.insert(0, "P:");
		return temp.toString();
	}

	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
		String line = null;

		StringBuilder sBuilder = new StringBuilder();

		while (scan.hasNextLine()) {
			line = scan.nextLine();
			if (line.length() == 0) {
				break;
			}
			
			if (line.startsWith("E")) {
				sBuilder.append(processE(line)).append("\n");
			} else if (line.startsWith("P")) {
				sBuilder.append(processP(line)).append("\n");
			}
		}
		sBuilder.setLength(sBuilder.length() - 1);
		scan.close();

		System.out.println(sBuilder.toString());
	}
}