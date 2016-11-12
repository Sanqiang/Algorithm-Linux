/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.SortAndSearch;

public class SelectSort<T extends Comparable<T>> extends SortBase<T> {

    public SelectSort(T[] _array) {
        super(_array);
    }

    @Override
    void sort() {
        int k, i, j, length = array.length;
        for (i = 0; i < length; i++) {
            k = i;
            for (j = i; j < length; j++) {
                if (array[k].compareTo(array[j]) > 0) {
                    k = j;
                }
            }
            if (k != i) {
                swap(k, i);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {8, 6, 4, 2, 3};
        SelectSort<Integer> ss = new SelectSort<>(arr);
        ss.sort();
        for (Integer integer : ss.array) {
            System.out.println(integer);
        }
    }
}
