/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.SortAndSearch;

public class QuickSort<T extends Comparable<T>> extends SortBase<T> {

    public QuickSort(T[] _array) {
        super(_array);
    }

    @Override
    void sort() {
        split(0, array.length - 1);
    }

    void split(int s, int e) {
        if (s > e) {
            return;
        }
        int pivot = partition(s, e);
        split(s, pivot - 1);
        split(pivot + 1, e);
    }

    int partition(int s, int e) {
        T pivot = array[s];
        while (s < e) {
            for (; s < e && array[e].compareTo(pivot) >= 0; --e);
            array[s] = array[e];
            for (; s < e && array[s].compareTo(pivot) <= 0; ++s);
            array[e] = array[s];
        }
        array[s] = pivot;
        return s;
    }

    public static void main(String[] args) {
        Integer[] arr = {8, 6, 4, 2, 3};
        QuickSort<Integer> qs = new QuickSort<>(arr);
        qs.sort();
        for (Integer integer : qs.array) {
            System.out.println(integer);
        }
    }
}
