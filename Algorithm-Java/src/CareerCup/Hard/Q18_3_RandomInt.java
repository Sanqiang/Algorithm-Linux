/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.Hard;

public class Q18_3_RandomInt {

    public int[] generate(int[] original, int m) {
        int[] subset = new int[m];
        int[] array = original.clone();
        for (int i = 0; i < m; i++) {
            int j = i + (int) (Math.random() * (m - i));
            subset[i] = array[j];
            array[j] = array[i];
        }
        return subset;
    }

    public static void main(String[] args) {
    }
}
