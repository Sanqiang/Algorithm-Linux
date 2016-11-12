/**
 * Sanqiang Zhao Www.131X.Com Dec 19, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_9_FileSystem;

import java.util.HashSet;

public class Directory extends Entry {

    public HashSet<Entry> files;

    public Directory(String _name, Directory _parent) {
        super(_name, _parent);
        files = new HashSet<>();
    }

    @Override
    public int size() {
        int size = 0;
        for (Entry e : files) {
            size += e.size();
        }
        return size;
    }

    @Override
    public void delete() {
        for (Entry e : files) {
            e.delete();
        }
        this.remove = true;
    }

    public void deleteEntry(Entry e) {
        files.remove(e);
    }

    public void addEntry(Entry e) {
        files.add(e);
    }

    public int numfiles() {
        int count = 0;
        for (Entry e : files) {
            if (e instanceof File) {
                ++count;
            } else if (e instanceof Directory) {
                count += ((Directory) e).numfiles();
            }
        }
        return count;
    }

    public static void main(String[] args) {
    }
}
