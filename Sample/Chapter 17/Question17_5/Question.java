package Question17_5;

public class Question {

	public static class Result {
		public int hits;
		public int pseudoHits;
		
		public String toString() {
			return "(" + hits + ", " + pseudoHits + ")";
		}
	};
	
	public static int code(char c) {
		switch (c) {
		case 'B':
			return 0;
		case 'G':
			return 1;
		case 'R':
			return 2;
		case 'Y':
			return 3;
		default:
			return -1;
		}
	}
	
	public static int MAX_COLORS = 4;
	
	public static Result estimate(String guess, String solution) {
		if (guess.length() != solution.length()) return null;
		Result res = new Result();
		int[] frequencies = new int[MAX_COLORS];
		    
		/* Compute hits and built frequency table */
		for (int i = 0; i < guess.length(); i++) {
			if (guess.charAt(i) == solution.charAt(i)) {
				res.hits++;
			} else {
				/* Only increment the frequency table (which will be used for pseudo-hits) if
				 * it's not a hit. If it's a hit, the slot has already been "used." */
				int code = code(solution.charAt(i));
				if (code >= 0) {
					frequencies[code]++;
				}
			}
		}
		
		/* Compute pseudo-hits */
		for (int i = 0; i < guess.length(); i++) {
			int code = code(guess.charAt(i));
			if (code >= 0 && frequencies[code] > 0) {
				res.pseudoHits++;
				frequencies[code]--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Result res = estimate("GGRR", "RGBY"); // first param is guess, second is solution
		System.out.println(res.toString());
	}

}
