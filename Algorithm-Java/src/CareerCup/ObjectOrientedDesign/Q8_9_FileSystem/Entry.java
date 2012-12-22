/**
 * Sanqiang Zhao Www.131X.Com Dec 19, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_9_FileSystem;

public abstract class Entry {

    public long date_create;
    public long date_update;
    public long date_access;
    public String name;
    public Directory parent;
    public boolean remove;

    public Entry(String _name, Directory _parent) {
        this.name = _name;
        this.parent = _parent;
        date_create = System.currentTimeMillis();
        date_update = System.currentTimeMillis();
        date_access = System.currentTimeMillis();
        remove = false;
    }

    public void deleteParent() {
        if (parent != null) {
            parent.delete();
        }
    }

    public abstract int size();

    public abstract void delete();

    public static void main(String[] args) {
    }
}
