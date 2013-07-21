/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.SortAndSearch;

import Util.TestUtil;
import java.util.Random;

public class QuickSort<T extends Comparable<T>> extends SortBase<T> {

    public QuickSort(T[] _array) {
        super(_array);
    }
    public boolean Random = false;

    @Override
    void sort() {
        split(0, array.length - 1);
    }

    void split(int s, int e) {
        if (s >= e) {
            return;
        }
        int pivot = 0;
        if (Random) {
            pivot = partitionRandom(s, e);
        } else {
            pivot = partition(s, e);
        }
        split(s, pivot - 1);
        split(pivot + 1, e);
    }

    int partitionRandom(int s, int e) {
        int pivot_ind = s + new Random().nextInt(e - s + 1);
        T pivot_val = array[pivot_ind];
        swap(pivot_ind, s);
        int a = s + 1, b = s + 1;
        while (b <= e) {
            if (array[b].compareTo(pivot_val) < 0) {
                swap(b, a++);
            }
            ++b;
        }
        swap(a - 1, s);
        return a - 1;
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
        Integer[] arr = {8, 6, 4, 2, 3, 1, 2, 3, 4, 100, 9};
        QuickSort<Integer> qs = new QuickSort<>(arr);
        qs.Random = true;
        qs.sort();
        for (Integer integer : qs.array) {
            System.out.println(integer);
        }

        Integer[] test1 = TestUtil.intToInteger(TestUtil.generateArray(0xffff));
        Integer[] test2 = test1.clone();
        long t1 = System.currentTimeMillis();
        QuickSort<Integer> q1 = new QuickSort<>(test1);
        q1.sort();
        long t2 = System.currentTimeMillis();
        QuickSort<Integer> q2 = new QuickSort<>(test2);
        q2.sort();
        long t3 = System.currentTimeMillis();
        long span1 = t2 - t1, span2 = t3 - t2;
        System.out.print("Random:" + span1 + "\r\nFirst:" + span2);
    }
}
