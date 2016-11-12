/**
 * Sanqiang Zhao Www.131X.Com Dec 18, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_10_HashTable;

public class HashTable<K, V> {

    public int Capacity = 1000;
    public Entry<K, V>[] array;

    public HashTable() {
        array = new Entry[Capacity];
    }

    public HashTable(int _capacity) {
        this.Capacity = _capacity;
        array = new Entry[Capacity];
    }

    public synchronized void put(K key, V value) {
        int hash = key.hashCode() % Capacity;
        Entry<K, V> new_entry = new Entry(key, value);
        if (array[hash] == null) {
            array[hash] = new_entry;
        } else {
            array[hash].addEntry(new_entry);
        }
    }

    public synchronized V get(K key) {
        int hash = key.hashCode() % Capacity;
        Entry<K, V> e = array[hash];
        while (e != null && !e.getKey().equals(key)) {
            e = e.getNext();
        }
        if (e == null) {
            return null;
        } else {
            return e.getValue();
        }
    }

    public synchronized void delete(K key) {
        int hash = key.hashCode() % Capacity;
        if (array[hash] != null && array[hash].getKey() == key) {
            array[hash] = array[hash].getNext();
        } else {
            array[hash].deleteEntry(key);
        }
    }

    public static void main(String[] args) {
        HashTable<Integer, String> ht = new HashTable<>(10);
        ht.put(1, "xxx");
        ht.put(2, "yyy");
        ht.put(3, "zzz");
        ht.put(4, "qqq");
        System.out.println(ht.get(1));
        System.out.println(ht.get(2));
        //ht.delete(1);
        System.out.println(ht.get(1));
        //ht.delete(2);
        ht.put(2, "ZSQ");
        System.out.println(ht.get(2));
    }
}
