/**
 * Sanqiang Zhao Www.131X.Com Dec 18, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_10_HashTable;

public class Entry<K, V> {

    private V Value;

    public V getValue() {
        return Value;
    }

    public void setValue(V Value) {
        this.Value = Value;
    }
    private K Key;

    public K getKey() {
        return Key;
    }

    public void setKey(K Key) {
        this.Key = Key;
    }
    private Entry Next;

    public Entry getNext() {
        return Next;
    }

    public void setNext(Entry Next) {
        this.Next = Next;
    }

    public Entry(K _k, V _v) {
        this.Key = _k;
        this.Value = _v;
        this.Next = null;
    }

    public void addEntry(Entry _e) {
        Entry runner = this;
        if (runner != null && runner.getKey() == _e.Key) {
            runner.setValue(_e.Value);
            return;
        }
        while (runner.Next != null) {
            runner = runner.Next;
            if (runner != null && runner.getKey() == _e.Key) {
                runner.setValue(_e.Value);
                return;
            }
        }
        runner.Next = _e;
    }

    public void deleteEntry(K key) {
        Entry runner = this;
        while (runner != null) {
            Entry next_entry = runner.getNext();
            if (next_entry != null && next_entry.getKey() == key) {
                runner.setNext(next_entry.getNext());
                return;
            }
            runner = next_entry;
        }
    }

    public static void main(String[] args) {
    }
}
