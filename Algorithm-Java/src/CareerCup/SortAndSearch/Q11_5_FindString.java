/**
 * Sanqiang Zhao Www.131X.Com Jan 5, 2013
 */
package CareerCup.SortAndSearch;

public class Q11_5_FindString {

    public int find(String[] list, String target, int s, int e) {
        if (s > e) {
            return -1;
        }
        int m = s + (e - s) / 2;
        if (list[m].length() == 0) {
            int dif = 1;
            while (m + dif <= e && m - dif >= s) {
                if (list[m + dif].length() != 0) {
                    m = m + dif;
                } else if (list[m - dif].length() != 0) {
                    m = m - dif;
                }
                ++dif;
            }
        }
        if (target.compareTo(list[m]) > 0) {
            return find(list, target, m + 1, e);
        } else if (target.compareTo(list[m]) < 0) {
            return find(list, target, s, m - 1);
        } else {
            return m;
        }
    }

    public static void main(String[] args) {
    }
}
