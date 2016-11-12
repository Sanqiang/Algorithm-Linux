/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.SortAndSearch;

public class InsertSort<T extends Comparable<T>> extends SortBase<T> {

    public InsertSort(T[] _array) {
        super(_array);
    }

    @Override
    void sort() {
        int i, j, length = array.length;
        for (i = 0; i < length; ++i) {
            for (j = i; j - 1 >= 0 && array[j].compareTo(array[j - 1]) < 0; --j) {
                swap(j, j - 1);
            }
        }
    }
    final int[] Marcin_Ciura_Gap = {701, 301, 132, 57, 23, 10, 4, 1};

    void sort_shell() {
        int i, j, length = array.length;
        for (int step : Marcin_Ciura_Gap) {
            for (i = 0; i < length; i += step) {
                for (j = i; j - step >= 0 && array[j].compareTo(array[j - step]) < 0; j -= step) {
                    swap(j, j - step);
                }
            }
        }

    }

    public static void main(String[] args) {
        Integer[] arr = {8, 6, 4, 2, 3, 0, 2, 10, 12};
        InsertSort<Integer> is = new InsertSort<>(arr);
        //is.sort();
        is.sort_shell();
        for (Integer integer : is.array) {
            System.out.println(integer);
        }
    }
}
