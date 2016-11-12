/**
 * Sanqiang Zhao Www.131X.Com Jan 5, 2013
 */
package CareerCup.RecursiveAndDP;

public class Q9_3_MagicIndex {

    public int find(int[] array) {
        int s = 0, length = array.length, e = length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (m == array[m]) {
                return m;
            } else if (m > array[m]) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return -1;
    }

    public int findWithOverlap(int[] array, int s, int e) {
        if (s > e) {
            return -1;
        }
        int m = s + (e - s) / 2;
        if (m == array[m]) {
            return m;
        }
        int l = Math.min(array[m], m - 1);
        int result = findWithOverlap(array, s, l);
        if (result != -1) {
            return result;
        }
        int h = Math.max(array[m], m + 1);
        result = findWithOverlap(array, h, e);
        return result;
    }

    public static void main(String[] args) {
        Q9_3_MagicIndex q93 = new Q9_3_MagicIndex();
        int[] arr1 = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        int i1 = q93.find(arr1);
        System.out.println(i1);
        int[] arr2 = {-10, -5, 2, 2, 2, 3, 4, 8, 9, 12, 13};
        int i2 = q93.findWithOverlap(arr2, 0, arr2.length - 1);
        System.out.println(i2);
    }
}
