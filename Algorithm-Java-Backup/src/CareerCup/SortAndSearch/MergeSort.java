/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.SortAndSearch;

public class MergeSort<T extends Comparable<T>> extends SortBase<T> {

    public MergeSort(T[] _array) {
        super(_array);
    }

    @Override
    void sort() {
        split(0, array.length - 1);
    }

    void split(int s, int e) {
        if (s >= e) {
            return;
        }
        int m = s + (e - s) / 2;
        split(s, m);
        split(m + 1, e);
        merge(s, e, m);
    }

    //Java didnot support generic array creation
    void merge(int s, int e, int m) {
        Object[] ll = new Object[m - s + 1];
        Object[] rr = new Object[e - (m + 1) + 1];
        int i, j, k;
        for (i = 0; i < ll.length; i++) {
            ll[i] = array[s + i];
        }
        for (i = 0; i < rr.length; i++) {
            rr[i] = array[m + i + 1];
        }
        i = 0;
        j = 0;
        k = s;
        while (true) {
            if (i == ll.length) {
                while (j != rr.length) {
                    array[k++] = (T) rr[j++];
                }
                break;
            }
            if (j == rr.length) {
                while (i != ll.length) {
                    array[k++] = (T) ll[i++];
                }
                break;
            }
            T l = (T) ll[i];
            T r = (T) rr[j];
            if (l.compareTo(r) <= 0) {
                array[k++] = l;
                i++;
            } else {
                array[k++] = r;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {8, 6, 4, 2, 3};
        MergeSort<Integer> ms = new MergeSort<>(arr);
        ms.sort();
        for (Integer integer : ms.array) {
            System.out.println(integer);
        }
    }
}
