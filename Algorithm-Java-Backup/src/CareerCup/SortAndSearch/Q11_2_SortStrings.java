/**
 * Sanqiang Zhao Www.131X.Com Jan 5, 2013
 */
package CareerCup.SortAndSearch;

import java.util.Arrays;
import java.util.Comparator;

public class Q11_2_SortStrings {

    public void sort(String[] list) {
        Arrays.sort(list, new comp());
    }

    public class comp implements Comparator<String> {

        @Override
        public int compare(String t, String t1) {
            if (isAnagram(t, t1)) {
                return 0;
            } else {
                return t.hashCode() - t1.hashCode();
            }
        }

        private boolean isAnagram(String t, String t1) {
            int t_length = t.length(), t1_length = t1.length(), i;
            if (t_length != t1_length) {
                return false;
            }
            int[] tab = new int[0xff];
            for (i = 0; i < t_length; i++) {
                ++tab[t.charAt(i)];
            }
            for (i = 0; i < t1_length; i++) {
                --tab[t1.charAt(i)];
                if (tab[t1.charAt(i)] < 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String[] list = {"op", "d", "abb", "po", "bab", "po", "ki"};
        Q11_2_SortStrings q112 = new Q11_2_SortStrings();
        q112.sort(list);
        for (String string : list) {
            System.out.println(string);
        }
    }
}
