/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.SortAndSearch;

public class HeapSort<T extends Comparable<T>> extends SortBase<T> {

    public HeapSort(T[] _array) {
        super(_array);
    }

    public int getLeft(int index) {
        return index * 2 + 1;
    }

    public int getRight(int index) {
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
            swap(MaxIndex, index);
            maxHeapify(MaxIndex, size);
        }
    }

    @Override
    void sort() {
        int i, length = array.length;
        for (i = length / 2 - 1; i >= 0; --i) {
            maxHeapify(i, length);
        }
        for (i = length - 1; i >= 0; --i) {
            swap(i, 0);
            maxHeapify(0, i);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {8, 6, 4, 2, 3};
        HeapSort<Integer> hs = new HeapSort<>(arr);
        hs.sort();
        for (Integer integer : hs.array) {
            System.out.println(integer);
        }
    }
}
