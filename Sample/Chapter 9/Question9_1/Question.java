package Question9_1;

import java.util.HashMap;

public class Question {

	public static int countWaysDP(int n, HashMap<Integer, Integer> map) {
		if (map.containsKey(n)) {
			return map.get(n).intValue();
		}
		int q = 0;
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			q = 1;
		} else {
			q = countWaysDP(n - 1, map) + countWaysDP(n - 2, map) + countWaysDP(n - 3, map);
		}
		map.put(n, q);
		return q;
	}
	
	public static int countWaysRecursive(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countWaysRecursive(n - 1) + countWaysRecursive(n - 2) + countWaysRecursive(n - 3);
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 30; i++) {
			long t1 = System.currentTimeMillis();
			HashMap<Integer, Integer> map = new  HashMap<Integer, Integer>();
			int c1 = countWaysDP(i, map);
			long t2 = System.currentTimeMillis();
			long d1 = t2 - t1;
			
			long t3 = System.currentTimeMillis();
			int c2 = countWaysRecursive(i);
			long t4 = System.currentTimeMillis();
			long d2 = t4 - t3;			
			System.out.println(i + " " + c1 + " " + c2 + " " + d1 + " " + d2);
		}
	}

}
