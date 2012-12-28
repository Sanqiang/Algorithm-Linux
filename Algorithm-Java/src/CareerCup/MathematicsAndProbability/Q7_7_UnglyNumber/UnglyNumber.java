/**
 * Sanqiang Zhao Www.131X.Com Dec 28, 2012
 */
package CareerCup.MathematicsAndProbability.Q7_7_UnglyNumber;

import java.util.LinkedList;
import java.util.Queue;

public class UnglyNumber {

    public int getKthUnglyNumber(int k) {
        Queue<Integer> s3 = new LinkedList<>();
        Queue<Integer> s5 = new LinkedList<>();
        Queue<Integer> s7 = new LinkedList<>();
        int val = 1;
        s3.add(1);
        while (--k > 0) {
            int v3 = s3.isEmpty() ? Integer.MAX_VALUE : s3.peek();
            int v5 = s5.isEmpty() ? Integer.MAX_VALUE : s5.peek();
            int v7 = s7.isEmpty() ? Integer.MAX_VALUE : s7.peek();
            val = Math.min(v7, Math.min(v3, v5));
            if (val == v3) {
                s3.poll();
                s3.add(val * 3);
                s5.add(val * 5);
                s7.add(val * 7);
            } else if (val == v5) {
                s5.poll();
                s5.add(val * 5);
                s7.add(val * 7);
            } else if (val == v7) {
                s7.poll();
                s7.add(val * 7);
            }
            System.out.println(val);
        }
        return val;
    }

    public static void main(String[] args) {
        new UnglyNumber().getKthUnglyNumber(100);
    }
}
