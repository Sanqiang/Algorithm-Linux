/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.SortAndSearch;

import java.util.Random;

public class NthBiggest<T extends Comparable<T>> extends SortBase<T> {

    int k;

    public NthBiggest(T[] _array, int _k) {
        super(_array);
        this.k = _k;
    }

    @Override
    void sort() {
        int i, length = array.length;
        for (i = length / 2 - 1; i >= 0; --i) {
            maxHeapify(i, length);
        }
        for (i = length - 1; i > length - 1 - k; --i) {
            swap(0, i);
            maxHeapify(0, i);
        }
    }

    void sort2() {
        sort_selection(0, array.length - 1, k);
    }

    void sort_selection(int s, int e, int k) {
        int random = new Random().nextInt(e - s + 1) + s;
        T pivot = array[random];
        int LeftEnd = selection_partition(s, e, pivot);
        int LeftSize = LeftEnd - s + 1;
        if (LeftSize == k) {
            return;
        } else if (LeftSize < k) {
            sort_selection(LeftEnd + 1, e, k - LeftSize);
        } else {
            sort_selection(s, LeftEnd, k);
        }

    }

    int selection_partition(int s, int e, T pivot) {
        while (true) {
            for (; s <= e && array[s].compareTo(pivot) <= 0; ++s);
            for (; s <= e && array[e].compareTo(pivot) >= 0; --e);
            if (s > e) {
                return s - 1;
            }
            swap(s, e);
        }
    }

    private int getLeft(int index) {
        return index * 2 + 1;
    }

    private int getRight(int index) {
        return index * 2 + 2;
    }

    public void maxHeapify(int index, int size) {
        int l = getLeft(index);
        int r = getRight(index);
        int MaxIndex = index;
        if (l < size && array[l].compareTo(array[MaxIndex]) > 0) {
            MaxIndex = l;
        }
        if (r < size && array[r].compareTo(array[MaxIndex]) > 0) {
            MaxIndex = r;
        }
        if (MaxIndex != index) {
            swap(index, MaxIndex);
            maxHeapify(MaxIndex, size);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {10,0, 9, 3, 8, 1,7, 6};
        NthBiggest<Integer> nb = new NthBiggest<>(arr, 2);
        //nb.sort();
        nb.sort2();;
        for (Integer integer : nb.array) {
            System.out.println(integer);
        }
    }
}
