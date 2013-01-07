/**
 * Sanqiang Zhao Www.131X.Com Jan 5, 2013
 */
package CareerCup.SortAndSearch;

public class Q11_1_Merge {

    public void merge(int[] large, int[] small, int len_large, int len_small) {
        int index_large = len_large - 1;
        int index_small = len_small - 1;
        int index = large.length - 1;
        while (true) {
            if (index_large < 0) {
                while (index_small >= 0) {
                    large[index--] = small[index_small--];
                }
                return;
            } else if (index_small < 0) {
                return;
            }
            if (large[index_large] <= small[index_small]) {
                large[index--] = small[index_small--];
            } else {
                large[index--] = large[index_large--];
            }
        }
    }

    public static void main(String[] args) {
    }
}
