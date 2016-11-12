/**
 * Sanqiang Zhao Www.131X.Com Dec 29, 2012
 */
package CareerCup.Moderate;

public class Q17_5_MasterMind {

    public class Result {

        public int hits = 0;
        public int pseudo_hits = 0;

        @Override
        public String toString() {
            return "Hits:" + hits + " PseudoHits:" + pseudo_hits;
        }
    }

    public int code(char c) {
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
    final short NUM_COLORS = 4;

    public Result estimate(String guess, String solution) {
        if (guess.length() != solution.length()) {
            return null;
        }
        Result r = new Result();
        short frequency[] = new short[NUM_COLORS];
        int i, length = solution.length();
        for (i = 0; i < length; i++) {
            if (guess.charAt(i) == solution.charAt(i)) {
                ++r.hits;
            } else {
                ++frequency[code(solution.charAt(i))];
            }
        }
        for (i = 0; i < length; i++) {
            if (guess.charAt(i) != solution.charAt(i) 
                    && frequency[code(guess.charAt(i))] > 0 
                    && code(guess.charAt(i)) >= 0) {
                --frequency[code(guess.charAt(i))];
                ++r.pseudo_hits;
            }
        }
        return r;
    }

    public static void main(String[] args) {
    }
}
