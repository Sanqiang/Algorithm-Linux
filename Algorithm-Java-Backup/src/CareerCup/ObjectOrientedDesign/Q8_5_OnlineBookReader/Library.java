/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_5_OnlineBookReader;

import CareerCup.ObjectOrientedDesign.Q8_10_HashTable.HashTable;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Iterator;

public class Library {

    private HashTable<Integer, Book> DB;
    private static Library inst;

    private Library() {
        DB = new HashTable<>();
    }

    public static Library getInstance() {
        if (inst == null) {
            inst = new Library();
        }
        return inst;
    }

    public void bulkAddBook(Dictionary<Integer, Book> list) {
        Enumeration<Integer> keys = list.keys();
        for (; keys.hasMoreElements();) {
            int id = keys.nextElement();
            Book book = list.get(id);
            DB.put(id, book);
        }
    }

    public Book find(int _book_id) {
        return DB.get(_book_id);
    }

    public static void main(String[] args) {
    }
}
