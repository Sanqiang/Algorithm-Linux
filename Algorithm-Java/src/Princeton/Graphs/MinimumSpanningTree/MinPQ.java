package Princeton.Graphs.MinimumSpanningTree;

import java.util.Iterator;

public class MinPQ<K> {

    private K[] pq;
    int n; // n means index  n+1 means num

    public K min() {
        return pq[0];
    }

    public MinPQ(int capability) {
        pq = (K[]) new Object[capability];
        n = -1;
    }

    public void insert(K v) {
        pq[++n] = v;
        if (n + 1 >= pq.length - 1) {
            increaseCapacity();
        }
        swim(n);
    }

    public K delMin() {
        K min = pq[0];
        exch(0, n--);
        sink(0);
        if (n < pq.length / 4) {
            decreaseCapacity();
        }
        return min;
    }

    private void increaseCapacity() {
        K[] n_pq = (K[]) new Object[pq.length * 2];
        for (int i = 0; i <= n; i++) {
            n_pq[i] = pq[i];
        }
        pq = n_pq;
    }

    private void decreaseCapacity() {
        K[] n_pq = (K[]) new Object[pq.length / 2];
        for (int i = 0; i <= n; i++) {
            n_pq[i] = pq[i];
        }
        pq = n_pq;
    }

    private void sink(int k) {
        while (k * 2 <= n) {
            int child = 2 * k + 1;
            if (child + 1 <= n && smaller(child + 1, child)) {
                ++child;
            }
            if (smaller(child, k)) {
                exch(k, child);
                k = child;
            } else {
                break;
            }
        }

    }

    private void swim(int k) {
        while (k > 0 && k / 2 < k) {
            int parent = (k - 1) / 2;
            if (smaller(k, parent)) {
                exch(parent, k);
            } else {
                break;
            }
        }
    }

    private boolean greater(K a, K b) {
        return ((Comparable<K>) a).compareTo(b) > 0;
    }

    private boolean smaller(int a, int b) {
        return ((Comparable<K>) pq[a]).compareTo(pq[b]) < 0;
    }

    private boolean greater(int a, int b) {
        return ((Comparable<K>) pq[a]).compareTo(pq[b]) > 0;
    }

    private void exch(int a, int b) {
        K temp = pq[a];
        pq[a] = pq[b];
        pq[b] = temp;
    }

    public static void main(String[] args) {
        MinPQ<Integer> mp = new MinPQ<Integer>(1);
        mp.insert(3);
        System.out.println(mp.min());
        mp.insert(2);
        System.out.println(mp.min());
        mp.insert(1);
        System.out.println(mp.min());
        mp.insert(11);
        System.out.println(mp.min());
        mp.insert(12);
        System.out.println(mp.min());
        mp.insert(13);
        System.out.println(mp.min());
        mp.insert(14);
        System.out.println(mp.min());
        mp.insert(15);
        System.out.println(mp.min());
        System.out.println(mp.delMin());
        System.out.println(mp.delMin());
        System.out.println(mp.delMin());
    }
}
